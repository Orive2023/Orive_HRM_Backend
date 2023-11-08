package com.orive.Accounts.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Accounts.Dto.SubTypeDto;
import com.orive.Accounts.Entity.SubTypeEntity;
import com.orive.Accounts.Repository.SubTypeRepository;

@Service
public class SubTypeSevice {

	 private static final Logger logger= LoggerFactory.getLogger(SubTypeSevice.class);
		
		@Autowired
		private SubTypeRepository subTypeRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		// Create
	    public SubTypeDto createSubTypeList(SubTypeDto accountListDto) {
	    	SubTypeEntity accountListEntity = convertToEntity(accountListDto);
	    	SubTypeEntity savedAccountList = subTypeRepository.save(accountListEntity);
	        logger.info("Created AccountList with ID: {}", savedAccountList.getSubTypeId());
	        return convertToDTO(savedAccountList);
	    }

	    // Read
	    public List<SubTypeDto> getAllSubTypeList() {
	        List<SubTypeEntity> accountListEntities = subTypeRepository.findAll();
	        logger.info("Retrieved {} AccountList from the database", accountListEntities.size());
	        return accountListEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by AccountListId
	    public Optional<SubTypeDto> getSubTypeById(Long subTypeId) {
	        Optional<SubTypeEntity> accountList = subTypeRepository.findById(subTypeId);
	        if (accountList.isPresent()) {
	            return Optional.of(convertToDTO(accountList.get()));
	        } else {
	            logger.warn("AccountList with ID {} not found", subTypeId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public SubTypeDto updateSubTypeList(Long subTypeId, SubTypeDto accountListDto) {
	        Optional<SubTypeEntity> existingAccountListOptional = subTypeRepository.findById(subTypeId);
	        if (existingAccountListOptional.isPresent()) {
	        	SubTypeEntity existingAccountList = existingAccountListOptional.get();
	            modelMapper.map(accountListDto, existingAccountListOptional);
	            SubTypeEntity updatedAccountList = subTypeRepository.save(existingAccountList);
	            logger.info("Updated AccountList with ID: {}", updatedAccountList.getSubTypeId());
	            return convertToDTO(updatedAccountList);
	        } else {
	            logger.warn("AccountList with ID {} not found for update",subTypeId );
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteSubTypeList(Long subTypeId) {
	    	subTypeRepository.deleteById(subTypeId);
	        logger.info("Deleted AccountList with ID: {}", subTypeId);
	    }

	    //count the total AccountList
	    public long countSubTypeList()
		 {
			 return subTypeRepository.count();
		 }
	    
		// Helper method to convert AccountListDTo to AccountListEntity
	    private SubTypeEntity convertToEntity(SubTypeDto accountListDto )
	    {
	    	return modelMapper.map(accountListDto, SubTypeEntity.class);
	    }

	    // Helper method to convert AccountListEntity  to AccountListDTo
	    private SubTypeDto convertToDTO(SubTypeEntity accountListEntity) {
	        return modelMapper.map(accountListEntity, SubTypeDto.class);
	    } 
}
