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

import com.orive.Accounts.Dto.OpeningBalanceDTo;
import com.orive.Accounts.Service.OpeningBalanceService;

@RestController
@RequestMapping(value = "openingbalance")
public class OpeningBalanceController {

private static final Logger logger=LoggerFactory.getLogger(OpeningBalanceController.class);
	
	@Autowired
	private OpeningBalanceService openingBalanceService;
	
	
	// Create a new AccountList
    @PostMapping("/create/openingBalance")
    public ResponseEntity<OpeningBalanceDTo> createOpeningBalance(@RequestBody OpeningBalanceDTo accountListDto) {
    	OpeningBalanceDTo createdAccountList = openingBalanceService.createOpeningBalance(accountListDto);
        logger.info("Created AccountList with year: {}", createdAccountList.getOpeningBalanceId());
        return new ResponseEntity<>(createdAccountList, HttpStatus.CREATED);
    }

    // Get all AccountList   
    @GetMapping("/get/openingBalance")
    public ResponseEntity<List<OpeningBalanceDTo>> getAllOpeningBalance() {
        List<OpeningBalanceDTo> accountList = openingBalanceService.getAllOpeningBalance();
        logger.info("Retrieved {} AccountList from the database", accountList.size());
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    // Get AccountList by ID
    @GetMapping("/get/{openingBalanceId}")
    public ResponseEntity<OpeningBalanceDTo> getOpeningBalanceById(@PathVariable Long openingBalanceId) {
        Optional<OpeningBalanceDTo> accountList = openingBalanceService.getOpeningBalanceById(openingBalanceId);
        if (accountList.isPresent()) {
            logger.info("Retrieved AccountList with ID: {}", openingBalanceId);
            return new ResponseEntity<>(accountList.get(), HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found", openingBalanceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update AccountList by ID
    @PutMapping("/update/{openingBalanceId}")
    public ResponseEntity<OpeningBalanceDTo> updateOpeningBalance(@PathVariable Long openingBalanceId, @RequestBody OpeningBalanceDTo updatedAccountListDto) {
    	OpeningBalanceDTo updatedAccountList = openingBalanceService.updateOpeningBalance(openingBalanceId, updatedAccountListDto);
        if (updatedAccountList != null) {
            logger.info("Updated AccountList with ID: {}", openingBalanceId);
            return new ResponseEntity<>(updatedAccountList, HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found for update", openingBalanceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete AccountList by ID
    @DeleteMapping("/delete/{openingBalanceId}")
    public ResponseEntity<Void> deleteOpeningBalance(@PathVariable Long openingBalanceId) {
    	openingBalanceService.deleteOpeningBalance(openingBalanceId);
        logger.info("Deleted AccountList with ID: {}", openingBalanceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/openingBalance")
	    public long countOpeningBalance()
	    {
	    	return openingBalanceService.countOpeningBalance();
	    }

}
