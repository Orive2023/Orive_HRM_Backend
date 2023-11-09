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

import com.orive.Accounts.Dto.JournalVoucherDto;
import com.orive.Accounts.Service.JournalVoucherService;

@RestController
@RequestMapping(value = "journalvoucher")
public class JournalVoucherController {

private static final Logger logger=LoggerFactory.getLogger(JournalVoucherController.class);
	
	@Autowired
	private JournalVoucherService journalVoucherService;
	
	
	// Create a new AccountList
    @PostMapping("/create/journalVoucher")
    public ResponseEntity<JournalVoucherDto> createJournalVoucher(@RequestBody JournalVoucherDto accountListDto) {
    	JournalVoucherDto createdAccountList = journalVoucherService.createJournalVoucher(accountListDto);
        logger.info("Created AccountList with year: {}", createdAccountList.getJournalVoucherId());
        return new ResponseEntity<>(createdAccountList, HttpStatus.CREATED);
    }

    // Get all AccountList   
    @GetMapping("/get/journalVoucher")
    public ResponseEntity<List<JournalVoucherDto>> getAllJournalVoucher() {
        List<JournalVoucherDto> accountList = journalVoucherService.getAllJournalVoucher();
        logger.info("Retrieved {} AccountList from the database", accountList.size());
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    // Get AccountList by ID
    @GetMapping("/get/{journalVoucherId}")
    public ResponseEntity<JournalVoucherDto> getJournalVoucherById(@PathVariable Long journalVoucherId) {
        Optional<JournalVoucherDto> accountList = journalVoucherService.getJournalVoucherById(journalVoucherId);
        if (accountList.isPresent()) {
            logger.info("Retrieved AccountList with ID: {}", journalVoucherId);
            return new ResponseEntity<>(accountList.get(), HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found", journalVoucherId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update AccountList by ID
    @PutMapping("/update/{journalVoucherId}")
    public ResponseEntity<JournalVoucherDto> updateJournalVoucher(@PathVariable Long journalVoucherId, @RequestBody JournalVoucherDto updatedAccountListDto) {
    	JournalVoucherDto updatedAccountList = journalVoucherService.updateJournalVoucher(journalVoucherId, updatedAccountListDto);
        if (updatedAccountList != null) {
            logger.info("Updated AccountList with ID: {}", journalVoucherId);
            return new ResponseEntity<>(updatedAccountList, HttpStatus.OK);
        } else {
            logger.warn("AccountList with ID {} not found for update", journalVoucherId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete AccountList by ID
    @DeleteMapping("/delete/{journalVoucherId}")
    public ResponseEntity<Void> deleteJournalVoucher(@PathVariable Long journalVoucherId) {
    	journalVoucherService.deleteJournalVoucher(journalVoucherId);
        logger.info("Deleted AccountList with ID: {}", journalVoucherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/journalVoucher")
	    public long countJournalVoucher()
	    {
	    	return journalVoucherService.countFinancialYearList();
	    }
}
