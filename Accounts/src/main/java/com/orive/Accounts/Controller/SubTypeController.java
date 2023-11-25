package com.orive.Accounts.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Accounts.Dto.SubTypeDto;
import com.orive.Accounts.Service.SubTypeSevice;

@RestController
@RequestMapping(value = "subtype")
@CrossOrigin(origins = "*")
public class SubTypeController {

	 private static final Logger logger=LoggerFactory.getLogger(SubTypeController.class);
		
		@Autowired
		private SubTypeSevice subTypeSevice;
		
		
		// Create a new AccountList
	    @PostMapping("/create/subType")
	    public ResponseEntity<SubTypeDto> createSubTypeList(@RequestBody SubTypeDto accountListDto) {
	    	SubTypeDto createdAccountList = subTypeSevice.createSubTypeList(accountListDto);
	        logger.info("Created AccountList with year: {}", createdAccountList.getSubType());
	        return new ResponseEntity<>(createdAccountList, HttpStatus.CREATED);
	    }

	    // Get all AccountList   
	    @GetMapping("/get/subType")
	    public ResponseEntity<List<SubTypeDto>> getAllSubTypeList() {
	        List<SubTypeDto> accountList = subTypeSevice.getAllSubTypeList();
	        logger.info("Retrieved {} AccountList from the database", accountList.size());
	        return new ResponseEntity<>(accountList, HttpStatus.OK);
	    }

	    // Get AccountList by ID
	    @GetMapping("/get/{subTypeId}")
	    public ResponseEntity<SubTypeDto> getSubTypeById(@PathVariable Long subTypeId) {
	        Optional<SubTypeDto> accountList = subTypeSevice.getSubTypeById(subTypeId);
	        if (accountList.isPresent()) {
	            logger.info("Retrieved AccountList with ID: {}", subTypeId);
	            return new ResponseEntity<>(accountList.get(), HttpStatus.OK);
	        } else {
	            logger.warn("AccountList with ID {} not found", subTypeId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Update AccountList by ID
	    @PutMapping("/update/{subTypeId}")
	    public ResponseEntity<SubTypeDto> updateSubTypeList(@PathVariable Long subTypeId, @RequestBody SubTypeDto updatedAccountListDto) {
	    	SubTypeDto updatedAccountList = subTypeSevice.updateSubTypeList(subTypeId, updatedAccountListDto);
	        if (updatedAccountList != null) {
	            logger.info("Updated AccountList with ID: {}", subTypeId);
	            return new ResponseEntity<>(updatedAccountList, HttpStatus.OK);
	        } else {
	            logger.warn("AccountList with ID {} not found for update", subTypeId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    


	    // Delete AccountList by ID
	    @DeleteMapping("/delete/{subTypeId}")
	    public ResponseEntity<Void> deleteSubTypeList(@PathVariable Long subTypeId) {
	    	subTypeSevice.deleteSubTypeList(subTypeId);
	        logger.info("Deleted AccountList with ID: {}", subTypeId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		    
		    @GetMapping("/count/subType")
		    public long countSubTypeList()
		    {
		    	return subTypeSevice.countSubTypeList();
		    }

}
