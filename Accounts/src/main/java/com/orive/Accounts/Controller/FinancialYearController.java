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

import com.orive.Accounts.Dto.FinancialYearDto;
import com.orive.Accounts.Service.FinancialYearService;


@RestController
@RequestMapping(value = "financialyear")
public class FinancialYearController {

  private static final Logger logger=LoggerFactory.getLogger(FinancialYearController.class);
	
	@Autowired
	private FinancialYearService financialYearService;
	
	
	// Create a new AccountList
    @PostMapping("/create/financialYear")
    public ResponseEntity<FinancialYearDto> createFinancialYearList(@RequestBody FinancialYearDto accountListDto) {
    	FinancialYearDto createdAccountList = financialYearService.createFinancialYearList(accountListDto);
        logger.info("Created AccountList with year: {}", createdAccountList.getFinancialYear());
        return new ResponseEntity<>(createdAccountList, HttpStatus.CREATED);
    }

    // Get all AccountList   
    @GetMapping("/get/financialYear")
    public ResponseEntity<List<FinancialYearDto>> getAllFinancialYearList() {
        List<FinancialYearDto> accountList = financialYearService.getAllFinancialYearList();
        logger.info("Retrieved {} AccountList from the database", accountList.size());
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    // Get AccountList by ID
    @GetMapping("/get/{accountListId}")
    public ResponseEntity<FinancialYearDto> getFinancialYearListById(@PathVariable Long financialYearId) {
        Optional<FinancialYearDto> accountList = financialYearService.getFinancialYearById(financialYearId);
        if (accountList.isPresent()) {
            logger.info("Retrieved AccountList with ID: {}", financialYearId);
            return new ResponseEntity<>(accountList.get(), HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found", financialYearId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update AccountList by ID
    @PutMapping("/update/{financialYearId}")
    public ResponseEntity<FinancialYearDto> updateFinancialYearList(@PathVariable Long financialYearId, @RequestBody FinancialYearDto updatedAccountListDto) {
    	FinancialYearDto updatedAccountList = financialYearService.updateFinancialYearList(financialYearId, updatedAccountListDto);
        if (updatedAccountList != null) {
            logger.info("Updated AccountList with ID: {}", financialYearId);
            return new ResponseEntity<>(updatedAccountList, HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found for update", financialYearId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete AccountList by ID
    @DeleteMapping("/delete/{financialYearId}")
    public ResponseEntity<Void> deleteFinancialYearList(@PathVariable Long financialYearId) {
    	financialYearService.deleteFinancialYearList(financialYearId);
        logger.info("Deleted AccountList with ID: {}", financialYearId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/financialYear")
	    public long countFinancialYearList()
	    {
	    	return financialYearService.countFinancialYearList();
	    }
}
