package com.orive.bank.controller;

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

import com.orive.bank.dto.AddBankDto;
import com.orive.bank.service.AddBankService;

@RestController
@RequestMapping(value = "addbank")
@CrossOrigin(origins = "*")
public class AddBankController {
	
	private static final Logger logger=LoggerFactory.getLogger(AddBankController.class);
	
	@Autowired
	private AddBankService addBankService;
	
	// Create a new AddBank
    @PostMapping("/create/addbank")
    public ResponseEntity<AddBankDto> createAddBank(@RequestBody AddBankDto addBankDto) {
    	AddBankDto createdAddBank = addBankService.createAddBank(addBankDto);
        logger.info("Created AddBank with name: {}", createdAddBank.getAccountName());
        return new ResponseEntity<>(createdAddBank, HttpStatus.CREATED);
    }

    // Get all AddBank   
    @GetMapping("/get/addbank")
    public ResponseEntity<List<AddBankDto>> getAllAddBank() {
        List<AddBankDto> addBank = addBankService.getAllAddBank();
        logger.info("Retrieved {} AddBank from the database", addBank.size());
        return new ResponseEntity<>(addBank, HttpStatus.OK);
    }

    // Get AddBank by ID
    @GetMapping("/get/{addBankId}")
    public ResponseEntity<AddBankDto> getAddBankById(@PathVariable Long addBankId) {
        Optional<AddBankDto> addBank = addBankService.getAddBankById(addBankId);
        if (addBank.isPresent()) {
            logger.info("Retrieved AddBank with ID: {}", addBankId);
            return new ResponseEntity<>(addBank.get(), HttpStatus.OK);
        } else {
            logger.warn("AddBank with ID {} not found", addBankId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update AddBank by ID
    @PutMapping("/update/{addBankId}")
    public ResponseEntity<AddBankDto> updateAddBank(@PathVariable Long addBankId, @RequestBody AddBankDto updatedAddBankDto) {
    	AddBankDto updatedAddBank = addBankService.updateAddBank(addBankId, updatedAddBankDto);
        if (updatedAddBank != null) {
            logger.info("Updated AddBank with ID: {}", addBankId);
            return new ResponseEntity<>(updatedAddBank, HttpStatus.OK);
        } else {
            logger.warn("AddBank with ID {} not found for update", addBankId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete AddBank by ID
    @DeleteMapping("/delete/{addBankId}")
    public ResponseEntity<Void> deleteAddBank(@PathVariable Long addBankId) {
    	addBankService.deleteAddBank(addBankId);
        logger.info("Deleted AddBank with ID: {}", addBankId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
   // count the total AddBank
	    @GetMapping("/count/addbank")
	    public long countAddBank()
	    {
	    	return addBankService.countAddBank();
	    }
}
