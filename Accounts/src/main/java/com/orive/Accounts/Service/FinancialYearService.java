package com.orive.Accounts.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Accounts.Dto.FinancialYearDto;
import com.orive.Accounts.Entity.FinancialYearEntity;
import com.orive.Accounts.Repository.FinancialYearRepository;



@Service
public class FinancialYearService {

    private static final Logger logger= LoggerFactory.getLogger(FinancialYearService.class);
	
	@Autowired
	private FinancialYearRepository financialYearRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public FinancialYearDto createFinancialYearList(FinancialYearDto accountListDto) {
    	FinancialYearEntity accountListEntity = convertToEntity(accountListDto);
    	FinancialYearEntity savedAccountList = financialYearRepository.save(accountListEntity);
        logger.info("Created AccountList with ID: {}", savedAccountList.getFinancialYearId());
        return convertToDTO(savedAccountList);
    }

    // Read
    public List<FinancialYearDto> getAllFinancialYearList() {
        List<FinancialYearEntity> accountListEntities = financialYearRepository.findAll();
        logger.info("Retrieved {} AccountList from the database", accountListEntities.size());
        return accountListEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by AccountListId
    public Optional<FinancialYearDto> getFinancialYearById(Long financialYearId) {
        Optional<FinancialYearEntity> accountList = financialYearRepository.findById(financialYearId);
        if (accountList.isPresent()) {
            return Optional.of(convertToDTO(accountList.get()));
        } else {
            logger.warn("AccountList with ID {} not found", financialYearId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public FinancialYearDto updateFinancialYearList(Long financialYearId, FinancialYearDto accountListDto) {
        Optional<FinancialYearEntity> existingAccountListOptional = financialYearRepository.findById(financialYearId);
        if (existingAccountListOptional.isPresent()) {
        	FinancialYearEntity existingAccountList = existingAccountListOptional.get();
        	existingAccountList.setFinancialYear(accountListDto.getFinancialYear());
        	existingAccountList.setFinancialYearStartDate(accountListDto.getFinancialYearStartDate());
        	existingAccountList.setFinancialYearEndDate(accountListDto.getFinancialYearEndDate());
            modelMapper.map(accountListDto, existingAccountListOptional);
            FinancialYearEntity updatedAccountList = financialYearRepository.save(existingAccountList);
            logger.info("Updated AccountList with ID: {}", updatedAccountList.getFinancialYearId());
            return convertToDTO(updatedAccountList);
        } else {
            logger.warn("AccountList with ID {} not found for update",financialYearId );
            return null;
        }
    }
    
    // Delete
    public void deleteFinancialYearList(Long financialYearId) {
    	financialYearRepository.deleteById(financialYearId);
        logger.info("Deleted AccountList with ID: {}", financialYearId);
    }

    //count the total AccountList
    public long countFinancialYearList()
	 {
		 return financialYearRepository.count();
	 }
    
	// Helper method to convert AccountListDTo to AccountListEntity
    private FinancialYearEntity convertToEntity(FinancialYearDto accountListDto )
    {
    	return modelMapper.map(accountListDto, FinancialYearEntity.class);
    }

    // Helper method to convert AccountListEntity  to AccountListDTo
    private FinancialYearDto convertToDTO(FinancialYearEntity accountListEntity) {
        return modelMapper.map(accountListEntity, FinancialYearDto.class);
    } 
}
