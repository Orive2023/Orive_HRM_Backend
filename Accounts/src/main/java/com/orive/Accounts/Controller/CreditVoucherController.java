package com.orive.Accounts.Controller;

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

import com.orive.Accounts.Dto.CreditVoucherDto;
import com.orive.Accounts.Service.CreditVoucherService;



@RestController
@RequestMapping(value = "creditvoucher")
public class CreditVoucherController {

	 private static final Logger logger=LoggerFactory.getLogger(CreditVoucherController.class);
		
		@Autowired
		private CreditVoucherService creditVoucherService;
		
		
		// Create a new AccountList
	    @PostMapping("/create/creditVoucher")
	    public ResponseEntity<CreditVoucherDto> createCreditVoucher(@RequestBody CreditVoucherDto accountListDto) {
	    	CreditVoucherDto createdAccountList = creditVoucherService.createCreditVoucher(accountListDto);
	        logger.info("Created AccountList with year: {}", createdAccountList.getCreditVoucherId());
	        return new ResponseEntity<>(createdAccountList, HttpStatus.CREATED);
	    }

	    // Get all AccountList   
	    @GetMapping("/get/creditVoucher")
	    public ResponseEntity<List<CreditVoucherDto>> getAllCreditVoucher() {
	        List<CreditVoucherDto> accountList = creditVoucherService.getAllCreditVoucher();
	        logger.info("Retrieved {} AccountList from the database", accountList.size());
	        return new ResponseEntity<>(accountList, HttpStatus.OK);
	    }

	    // Get AccountList by ID
	    @GetMapping("/get/{creditVoucherId}")
	    public ResponseEntity<CreditVoucherDto> getCreditVoucherById(@PathVariable Long creditVoucherId) {
	        Optional<CreditVoucherDto> accountList = creditVoucherService.getCreditVoucherById(creditVoucherId);
	        if (accountList.isPresent()) {
	            logger.info("Retrieved AccountList with ID: {}", creditVoucherId);
	            return new ResponseEntity<>(accountList.get(), HttpStatus.OK);
	        } else {
	            logger.warn("AccountList with ID {} not found", creditVoucherId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Update AccountList by ID
	    @PutMapping("/update/{creditVoucherId}")
	    public ResponseEntity<CreditVoucherDto> updateCreditVoucher(@PathVariable Long creditVoucherId, @RequestBody CreditVoucherDto updatedAccountListDto) {
	    	CreditVoucherDto updatedAccountList = creditVoucherService.updateCreditVoucher(creditVoucherId, updatedAccountListDto);
	        if (updatedAccountList != null) {
	            logger.info("Updated AccountList with ID: {}", creditVoucherId);
	            return new ResponseEntity<>(updatedAccountList, HttpStatus.OK);
	        } else {
	            logger.warn("AccountList with ID {} not found for update", creditVoucherId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    


	    // Delete AccountList by ID
	    @DeleteMapping("/delete/{creditVoucherId}")
	    public ResponseEntity<Void> deleteCreditVoucher(@PathVariable Long creditVoucherId) {
	    	creditVoucherService.deleteCreditVoucher(creditVoucherId);
	        logger.info("Deleted AccountList with ID: {}", creditVoucherId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		    
		    @GetMapping("/count/creditVoucher")
		    public long countCreditVoucherList()
		    {
		    	return creditVoucherService.countCreditVoucher();
		    }
}
