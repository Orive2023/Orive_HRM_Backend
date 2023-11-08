package com.orive.Accounts.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Accounts.Dto.CreditVoucherDto;
import com.orive.Accounts.Entity.CreditVoucherEntity;
import com.orive.Accounts.Repository.CreditVoucherRepository;



@Service
public class CreditVoucherService {

private static final Logger logger= LoggerFactory.getLogger(CreditVoucherService.class);
	
	@Autowired
	private CreditVoucherRepository creditVoucherRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public CreditVoucherDto createCreditVoucher(CreditVoucherDto accountListDto) {
    	CreditVoucherEntity accountListEntity = convertToEntity(accountListDto);
    	CreditVoucherEntity savedAccountList = creditVoucherRepository.save(accountListEntity);
        logger.info("Created AccountList with ID: {}", savedAccountList.getCreditVoucherId());
        return convertToDTO(savedAccountList);
    }

    // Read
    public List<CreditVoucherDto> getAllCreditVoucher() {
        List<CreditVoucherEntity> accountListEntities = creditVoucherRepository.findAll();
        logger.info("Retrieved {} AccountList from the database", accountListEntities.size());
        return accountListEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by AccountListId
    public Optional<CreditVoucherDto> getCreditVoucherById(Long creditVoucherId) {
        Optional<CreditVoucherEntity> accountList = creditVoucherRepository.findById(creditVoucherId);
        if (accountList.isPresent()) {
            return Optional.of(convertToDTO(accountList.get()));
        } else {
            logger.warn("AccountList with ID {} not found", creditVoucherId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public CreditVoucherDto updateCreditVoucher(Long creditVoucherId, CreditVoucherDto accountListDto) {
        Optional<CreditVoucherEntity> existingAccountListOptional = creditVoucherRepository.findById(creditVoucherId);
        if (existingAccountListOptional.isPresent()) {
        	CreditVoucherEntity existingAccountList = existingAccountListOptional.get();
            modelMapper.map(accountListDto, existingAccountListOptional);
            CreditVoucherEntity updatedAccountList = creditVoucherRepository.save(existingAccountList);
            logger.info("Updated AccountList with ID: {}", updatedAccountList.getCreditVoucherId());
            return convertToDTO(updatedAccountList);
        } else {
            logger.warn("AccountList with ID {} not found for update", creditVoucherId);
            return null;
        }
    }
    
    // Delete
    public void deleteCreditVoucher(Long creditVoucherId) {
    	creditVoucherRepository.deleteById(creditVoucherId);
        logger.info("Deleted AccountList with ID: {}", creditVoucherId);
    }

    //count the total AccountList
    public long countCreditVoucher()
	 {
		 return creditVoucherRepository.count();
	 }
    
	// Helper method to convert AccountListDTo to AccountListEntity
    private CreditVoucherEntity convertToEntity(CreditVoucherDto accountListDto )
    {
    	return modelMapper.map(accountListDto, CreditVoucherEntity.class);
    }

    // Helper method to convert AccountListEntity  to AccountListDTo
    private CreditVoucherDto convertToDTO(CreditVoucherEntity accountListEntity) {
        return modelMapper.map(accountListEntity, CreditVoucherDto.class);
    } 
}
