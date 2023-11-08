package com.orive.Accounts.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Accounts.Dto.OpeningBalanceDTo;
import com.orive.Accounts.Entity.OpeningBalanceEntity;
import com.orive.Accounts.Repository.OpeningBalanceRepository;

@Service
public class OpeningBalanceService {

    private static final Logger logger= LoggerFactory.getLogger(OpeningBalanceService.class);
	
	@Autowired
	private OpeningBalanceRepository openingBalanceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public OpeningBalanceDTo createOpeningBalance(OpeningBalanceDTo accountBalanceDto) {
    	OpeningBalanceEntity accountBalancesEntity = convertToEntity(accountBalanceDto);
    	OpeningBalanceEntity savedAccountBalance = openingBalanceRepository.save(accountBalancesEntity);
        logger.info("Created AccountBalance with ID: {}", savedAccountBalance.getOpeningBalanceId());
        return convertToDTO(savedAccountBalance);
    }

    // Read
    public List<OpeningBalanceDTo> getAllOpeningBalance() {
        List<OpeningBalanceEntity> accountBalancesEntities = openingBalanceRepository.findAll();
        logger.info("Retrieved {} AccountBalance from the database", accountBalancesEntities.size());
        return accountBalancesEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by AccountBalanceId
    public Optional<OpeningBalanceDTo> getOpeningBalanceById(Long openingBalanceId) {
        Optional<OpeningBalanceEntity> accountBalance = openingBalanceRepository.findById(openingBalanceId);
        if (accountBalance.isPresent()) {
            return Optional.of(convertToDTO(accountBalance.get()));
        } else {
            logger.warn("AccountBalance with ID {} not found", openingBalanceId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public OpeningBalanceDTo updateOpeningBalance(Long openingBalanceId, OpeningBalanceDTo accountBalanceDto) {
        Optional<OpeningBalanceEntity> existingAccountBalanceOptional = openingBalanceRepository.findById(openingBalanceId);
        if (existingAccountBalanceOptional.isPresent()) {
        	OpeningBalanceEntity existingAccountBalance = existingAccountBalanceOptional.get();
            modelMapper.map(accountBalanceDto, existingAccountBalanceOptional);
            OpeningBalanceEntity updatedAccountBalance = openingBalanceRepository.save(existingAccountBalance);
            logger.info("Updated AccountBalance with ID: {}", updatedAccountBalance.getOpeningBalanceId());
            return convertToDTO(updatedAccountBalance);
        } else {
            logger.warn("AccountBalance with ID {} not found for update", openingBalanceId);
            return null;
        }
    }
    
    // Delete
    public void deleteOpeningBalance(Long openingBalanceId) {
    	openingBalanceRepository.deleteById(openingBalanceId);
        logger.info("Deleted AccountBalance with ID: {}", openingBalanceId);
    }

    //count the total OpeningBalance
    public long countOpeningBalance()
	 {
		 return openingBalanceRepository.count();
	 }
    
	// Helper method to convert AccountBalanceDTo to AccountBalanceEntity
    private  OpeningBalanceEntity convertToEntity(OpeningBalanceDTo accountBalanceDto )
    {
    	return modelMapper.map(accountBalanceDto,OpeningBalanceEntity.class);
    }

    // Helper method to convert AccountBalanceEntity to AccountBalanceDTo
    private OpeningBalanceDTo convertToDTO(OpeningBalanceEntity accountBalancesEntity) 
    {
        return modelMapper.map(accountBalancesEntity, OpeningBalanceDTo.class);
    } 	
}
