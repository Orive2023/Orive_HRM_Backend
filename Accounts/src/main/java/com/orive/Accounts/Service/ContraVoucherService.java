package com.orive.Accounts.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Accounts.Dto.ContraVoucherDto;
import com.orive.Accounts.Entity.ContraVoucherEntity;
import com.orive.Accounts.Repository.ContraVoucherRepository;

@Service
public class ContraVoucherService {

private static final Logger logger= LoggerFactory.getLogger(ContraVoucherService.class);
	
	@Autowired
	private ContraVoucherRepository contraVoucherRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public ContraVoucherDto createContraVoucher(ContraVoucherDto accountListDto) {
    	ContraVoucherEntity accountListEntity = convertToEntity(accountListDto);
    	ContraVoucherEntity savedAccountList = contraVoucherRepository.save(accountListEntity);
        logger.info("Created AccountList with ID: {}", savedAccountList.getAccountName());
        return convertToDTO(savedAccountList);
    }

    // Read
    public List<ContraVoucherDto> getAllContraVoucher() {
        List<ContraVoucherEntity> accountListEntities = contraVoucherRepository.findAll();
        logger.info("Retrieved {} AccountList from the database", accountListEntities.size());
        return accountListEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by AccountListId
    public Optional<ContraVoucherDto> getContraVoucherById(Long contraVoucherId) {
        Optional<ContraVoucherEntity> accountList = contraVoucherRepository.findById(contraVoucherId);
        if (accountList.isPresent()) {
            return Optional.of(convertToDTO(accountList.get()));
        } else {
            logger.warn("AccountList with ID {} not found", contraVoucherId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public ContraVoucherDto updateContraVoucher(Long contraVoucherId, ContraVoucherDto accountListDto) {
        Optional<ContraVoucherEntity> existingAccountListOptional = contraVoucherRepository.findById(contraVoucherId);
        if (existingAccountListOptional.isPresent()) {
        	ContraVoucherEntity existingAccountList = existingAccountListOptional.get();
            modelMapper.map(accountListDto, existingAccountListOptional);
            ContraVoucherEntity updatedAccountList = contraVoucherRepository.save(existingAccountList);
            logger.info("Updated AccountList with ID: {}", updatedAccountList.getContraVoucherId());
            return convertToDTO(updatedAccountList);
        } else {
            logger.warn("AccountList with ID {} not found for update", contraVoucherId);
            return null;
        }
    }
    
    // Delete
    public void deleteContraVoucher(Long contraVoucherId) {
    	contraVoucherRepository.deleteById(contraVoucherId);
        logger.info("Deleted AccountList with ID: {}", contraVoucherId);
    }

    //count the total AccountList
    public long countContraVoucher()
	 {
		 return contraVoucherRepository.count();
	 }
    
	// Helper method to convert AccountListDTo to AccountListEntity
    private ContraVoucherEntity convertToEntity(ContraVoucherDto accountListDto )
    {
    	return modelMapper.map(accountListDto, ContraVoucherEntity.class);
    }

    // Helper method to convert AccountListEntity  to AccountListDTo
    private ContraVoucherDto convertToDTO(ContraVoucherEntity accountListEntity) {
        return modelMapper.map(accountListEntity, ContraVoucherDto.class);
    } 
}
