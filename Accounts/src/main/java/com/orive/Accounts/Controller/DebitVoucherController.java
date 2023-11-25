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

import com.orive.Accounts.Dto.DebitVoucherDto;
import com.orive.Accounts.Service.DebitVoucherService;



@RestController
@RequestMapping(value = "debitvoucher")
@CrossOrigin(origins = "*")
public class DebitVoucherController {

    private static final Logger logger=LoggerFactory.getLogger(DebitVoucherController.class);
	
	@Autowired
	private DebitVoucherService debitVoucherService;
	
	
	// Create a new AccountList
    @PostMapping("/create/debitVoucher")
    public ResponseEntity<DebitVoucherDto> createDebitVoucher(@RequestBody DebitVoucherDto accountListDto) {
    	DebitVoucherDto createdAccountList = debitVoucherService.createDebitVoucher(accountListDto);
        logger.info("Created AccountList with year: {}", createdAccountList.getDebitVoucherId());
        return new ResponseEntity<>(createdAccountList, HttpStatus.CREATED);
    }

    // Get all AccountList   
    @GetMapping("/get/debitVoucher")
    public ResponseEntity<List<DebitVoucherDto>> getAllDebitVoucher() {
        List<DebitVoucherDto> accountList = debitVoucherService.getAllDebitVoucher();
        logger.info("Retrieved {} AccountList from the database", accountList.size());
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    // Get AccountList by ID
    @GetMapping("/get/{debitVoucherId}")
    public ResponseEntity<DebitVoucherDto> getDebitVoucherById(@PathVariable Long debitVoucherId) {
        Optional<DebitVoucherDto> accountList = debitVoucherService.getDebitVoucherById(debitVoucherId);
        if (accountList.isPresent()) {
            logger.info("Retrieved AccountList with ID: {}", debitVoucherId);
            return new ResponseEntity<>(accountList.get(), HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found", debitVoucherId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update AccountList by ID
    @PutMapping("/update/{debitVoucherId}")
    public ResponseEntity<DebitVoucherDto> updateDebitVoucher(@PathVariable Long debitVoucherId, @RequestBody DebitVoucherDto updatedAccountListDto) {
    	DebitVoucherDto updatedAccountList = debitVoucherService.updateDebitVoucher(debitVoucherId, updatedAccountListDto);
        if (updatedAccountList != null) {
            logger.info("Updated AccountList with ID: {}", debitVoucherId);
            return new ResponseEntity<>(updatedAccountList, HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found for update", debitVoucherId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete AccountList by ID
    @DeleteMapping("/delete/{debitVoucherId}")
    public ResponseEntity<Void> deleteDebitVoucher(@PathVariable Long debitVoucherId) {
    	debitVoucherService.deleteDebitVoucher(debitVoucherId);
        logger.info("Deleted AccountList with ID: {}", debitVoucherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/debitVoucher")
	    public long countFinancialYearList()
	    {
	    	return debitVoucherService.countDebitVoucher();
	    }

}
