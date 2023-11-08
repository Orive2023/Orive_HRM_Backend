package com.orive.Accounts.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Accounts.Dto.DebitVoucherDto;
import com.orive.Accounts.Entity.DebitVoucherEntity;
import com.orive.Accounts.Repository.DebitVoucherRepository;



@Service
public class DebitVoucherService {

    private static final Logger logger= LoggerFactory.getLogger(DebitVoucherService.class);
	
	@Autowired
	private DebitVoucherRepository debitVoucherRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public DebitVoucherDto createDebitVoucher(DebitVoucherDto accountListDto) {
    	DebitVoucherEntity accountListEntity = convertToEntity(accountListDto);
    	DebitVoucherEntity savedAccountList = debitVoucherRepository.save(accountListEntity);
        logger.info("Created AccountList with ID: {}", savedAccountList.getDebitVoucherId());
        return convertToDTO(savedAccountList);
    }

    // Read
    public List<DebitVoucherDto> getAllDebitVoucher() {
        List<DebitVoucherEntity> accountListEntities = debitVoucherRepository.findAll();
        logger.info("Retrieved {} AccountList from the database", accountListEntities.size());
        return accountListEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by AccountListId
    public Optional<DebitVoucherDto> getDebitVoucherById(Long debitVoucherId) {
        Optional<DebitVoucherEntity> accountList = debitVoucherRepository.findById(debitVoucherId);
        if (accountList.isPresent()) {
            return Optional.of(convertToDTO(accountList.get()));
        } else {
            logger.warn("AccountList with ID {} not found", debitVoucherId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public DebitVoucherDto updateDebitVoucher(Long debitVoucherId, DebitVoucherDto accountListDto) {
        Optional<DebitVoucherEntity> existingAccountListOptional = debitVoucherRepository.findById(debitVoucherId);
        if (existingAccountListOptional.isPresent()) {
        	DebitVoucherEntity existingAccountList = existingAccountListOptional.get();
            modelMapper.map(accountListDto, existingAccountListOptional);
            DebitVoucherEntity updatedAccountList = debitVoucherRepository.save(existingAccountList);
            logger.info("Updated AccountList with ID: {}", updatedAccountList.getDebitVoucherId());
            return convertToDTO(updatedAccountList);
        } else {
            logger.warn("AccountList with ID {} not found for update", debitVoucherId);
            return null;
        }
    }
    
    // Delete
    public void deleteDebitVoucher(Long debitVoucherId) {
    	debitVoucherRepository.deleteById(debitVoucherId);
        logger.info("Deleted AccountList with ID: {}", debitVoucherId);
    }

    //count the total AccountList
    public long countDebitVoucher()
	 {
		 return debitVoucherRepository.count();
	 }
    
	// Helper method to convert AccountListDTo to AccountListEntity
    private DebitVoucherEntity convertToEntity(DebitVoucherDto accountListDto )
    {
    	return modelMapper.map(accountListDto, DebitVoucherEntity.class);
    }

    // Helper method to convert AccountListEntity  to AccountListDTo
    private DebitVoucherDto convertToDTO(DebitVoucherEntity accountListEntity) {
        return modelMapper.map(accountListEntity, DebitVoucherDto.class);
    } 
}
