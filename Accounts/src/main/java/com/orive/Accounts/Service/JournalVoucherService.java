package com.orive.Accounts.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Accounts.Dto.JournalVoucherDto;
import com.orive.Accounts.Entity.JournalVoucherEntity;
import com.orive.Accounts.Repository.JournalVoucherRepository;

@Service
public class JournalVoucherService {

	 private static final Logger logger= LoggerFactory.getLogger(FinancialYearService.class);
		
	 @Autowired
		private JournalVoucherRepository journalVoucherRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		// Create
	    public JournalVoucherDto createJournalVoucher(JournalVoucherDto accountListDto) {
	    	JournalVoucherEntity accountListEntity = convertToEntity(accountListDto);
	    	JournalVoucherEntity savedAccountList = journalVoucherRepository.save(accountListEntity);
	        logger.info("Created AccountList with ID: {}", savedAccountList.getJournalVoucherId());
	        return convertToDTO(savedAccountList);
	    }

	    // Read
	    public List<JournalVoucherDto> getAllJournalVoucher() {
	        List<JournalVoucherEntity> accountListEntities = journalVoucherRepository.findAll();
	        logger.info("Retrieved {} AccountList from the database", accountListEntities.size());
	        return accountListEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by AccountListId
	    public Optional<JournalVoucherDto> getJournalVoucherById(Long journalVoucherId) {
	        Optional<JournalVoucherEntity> accountList = journalVoucherRepository.findById(journalVoucherId);
	        if (accountList.isPresent()) {
	            return Optional.of(convertToDTO(accountList.get()));
	        } else {
	            logger.warn("AccountList with ID {} not found", journalVoucherId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public JournalVoucherDto updateJournalVoucher(Long journalVoucherId, JournalVoucherDto accountListDto) {
	        Optional<JournalVoucherEntity> existingAccountListOptional = journalVoucherRepository.findById(journalVoucherId);
	        if (existingAccountListOptional.isPresent()) {
	        	JournalVoucherEntity existingAccountList = existingAccountListOptional.get();
	            modelMapper.map(accountListDto, existingAccountListOptional);
	            JournalVoucherEntity updatedAccountList = journalVoucherRepository.save(existingAccountList);
	            logger.info("Updated AccountList with ID: {}", updatedAccountList.getJournalVoucherId());
	            return convertToDTO(updatedAccountList);
	        } else {
	            logger.warn("AccountList with ID {} not found for update",journalVoucherId );
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteJournalVoucher(Long journalVoucherId) {
	    	journalVoucherRepository.deleteById(journalVoucherId);
	        logger.info("Deleted AccountList with ID: {}", journalVoucherId);
	    }

	    //count the total AccountList
	    public long countFinancialYearList()
		 {
			 return journalVoucherRepository.count();
		 }
	    
		// Helper method to convert AccountListDTo to AccountListEntity
	    private JournalVoucherEntity convertToEntity(JournalVoucherDto accountListDto )
	    {
	    	return modelMapper.map(accountListDto, JournalVoucherEntity.class);
	    }

	    // Helper method to convert AccountListEntity  to AccountListDTo
	    private JournalVoucherDto convertToDTO(JournalVoucherEntity accountListEntity) {
	        return modelMapper.map(accountListEntity, JournalVoucherDto.class);
	    } 
}
