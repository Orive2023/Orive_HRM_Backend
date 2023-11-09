package com.orive.loan.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.loan.dto.GrantLoanDto;
import com.orive.loan.service.GrantLoanService;

@RestController
@RequestMapping(value = "grantloan")
public class GrantLoanController {
	
	private static final Logger logger = LoggerFactory.getLogger(GrantLoanController.class);
	
	@Autowired
	private GrantLoanService grantLoanService;
	
	// Create a new GrantLoan
    @PostMapping("/create/grantloan")
    public ResponseEntity<GrantLoanDto> createGrantLoan(@RequestBody GrantLoanDto grantLoanDto) {
    	GrantLoanDto createdGrantLoan = grantLoanService.createGrantLoan(grantLoanDto);
        logger.info("Created GrantLoan with name: {}", createdGrantLoan.getEmployeeName());
        return new ResponseEntity<>(createdGrantLoan, HttpStatus.CREATED);
    }

    // Get all GrantLoan   
    @GetMapping("/get/grantloan")
    public ResponseEntity<List<GrantLoanDto>> getAllGrantLoan() {
        List<GrantLoanDto> grantLoan = grantLoanService.getAllGrantLoan();
        logger.info("Retrieved {} GrantLoan from the database", grantLoan.size());
        return new ResponseEntity<>(grantLoan, HttpStatus.OK);
    }

    // Get GrantLoan by ID
    @GetMapping("/get/{grantLoanId}")
    public ResponseEntity<GrantLoanDto> getGrantLoanById(@PathVariable Long grantLoanId) {
        Optional<GrantLoanDto> grantLoan = grantLoanService.getGrantLoanById(grantLoanId);
        if (grantLoan.isPresent()) {
            logger.info("Retrieved GrantLoan with ID: {}", grantLoanId);
            return new ResponseEntity<>(grantLoan.get(), HttpStatus.OK);
        } else {
            logger.warn("GrantLoan with ID {} not found", grantLoanId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update GrantLoan by ID
    @PutMapping("/update/{grantLoanId}")
    public ResponseEntity<GrantLoanDto> updateGrantLoan(@PathVariable Long grantLoanId, @RequestBody GrantLoanDto updatedGrantLoanDto) {
    	GrantLoanDto updatedGrantLoan = grantLoanService.updateGrantLoan(grantLoanId, updatedGrantLoanDto);
        if (updatedGrantLoan != null) {
            logger.info("Updated GrantLoan with ID: {}", grantLoanId);
            return new ResponseEntity<>(updatedGrantLoan, HttpStatus.OK);
        } else {
            logger.warn("GrantLoan with ID {} not found for update", grantLoanId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete GrantLoan by ID
    @DeleteMapping("/delete/{grantLoanId}")
    public ResponseEntity<Void> deleteGrantLoan(@PathVariable Long grantLoanId) {
    	grantLoanService.deleteGrantLoan(grantLoanId);
        logger.info("Deleted GrantLoan with ID: {}", grantLoanId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/grantloan")
	    public long countGrantLoan()
	    {
	    	return grantLoanService.countGrantLoan();
	    }
}
