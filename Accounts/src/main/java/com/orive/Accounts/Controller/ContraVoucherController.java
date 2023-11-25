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

import com.orive.Accounts.Dto.ContraVoucherDto;
import com.orive.Accounts.Service.ContraVoucherService;

@RestController
@RequestMapping(value = "contravoucher")
@CrossOrigin(origins = "*")
public class ContraVoucherController {

     private static final Logger logger=LoggerFactory.getLogger(ContraVoucherController.class);
	
	@Autowired
	private ContraVoucherService contraVoucherService;
	
	
	// Create a new AccountList
    @PostMapping("/create/contraVoucher")
    public ResponseEntity<ContraVoucherDto> createContraVoucher(@RequestBody ContraVoucherDto accountListDto) {
    	ContraVoucherDto createdAccountList = contraVoucherService.createContraVoucher(accountListDto);
        logger.info("Created AccountList with name: {}", createdAccountList.getAccountName());
        return new ResponseEntity<>(createdAccountList, HttpStatus.CREATED);
    }

    // Get all AccountList   
    @GetMapping("/get/contraVoucher")
    public ResponseEntity<List<ContraVoucherDto>> getAllContraVoucher() {
        List<ContraVoucherDto> accountList = contraVoucherService.getAllContraVoucher();
        logger.info("Retrieved {} AccountList from the database", accountList.size());
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    // Get AccountList by ID
    @GetMapping("/get/{contraVoucherId}")
    public ResponseEntity<ContraVoucherDto> getContraVoucherById(@PathVariable Long contraVoucherId) {
        Optional<ContraVoucherDto> accountList = contraVoucherService.getContraVoucherById(contraVoucherId);
        if (accountList.isPresent()) {
            logger.info("Retrieved AccountList with ID: {}", contraVoucherId);
            return new ResponseEntity<>(accountList.get(), HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found", contraVoucherId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update AccountList by ID
    @PutMapping("/update/{contraVoucherId}")
    public ResponseEntity<ContraVoucherDto> updateContraVoucher(@PathVariable Long contraVoucherId, @RequestBody ContraVoucherDto updatedAccountListDto) {
    	ContraVoucherDto updatedAccountList = contraVoucherService.updateContraVoucher(contraVoucherId, updatedAccountListDto);
        if (updatedAccountList != null) {
            logger.info("Updated AccountList with ID: {}", contraVoucherId);
            return new ResponseEntity<>(updatedAccountList, HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found for update", contraVoucherId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete AccountList by ID
    @DeleteMapping("/delete/{contraVoucherId}")
    public ResponseEntity<Void> deleteContraVoucher(@PathVariable Long contraVoucherId) {
    	contraVoucherService.deleteContraVoucher(contraVoucherId);
        logger.info("Deleted AccountList with ID: {}", contraVoucherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/contraVoucher")
	    public long countContraVoucher()
	    {
	    	return contraVoucherService.countContraVoucher();
	    }
}
