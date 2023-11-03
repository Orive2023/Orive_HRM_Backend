package com.orive.Payroll.Controller;

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

import com.orive.Payroll.Dto.ManageSalaryDto;
import com.orive.Payroll.Service.ManageSalaryService;

@RestController
@RequestMapping(value = "managesalary")
public class ManageSalaryController {
	
	private static final Logger logger= LoggerFactory.getLogger(ManageSalaryController.class);
	
	@Autowired
	private ManageSalaryService manageSalaryService;
	
	 // Create a new ManageSalary
    @PostMapping("/create/managesalary")
    public ResponseEntity<ManageSalaryDto> createManageSalary(@RequestBody ManageSalaryDto manageSalaryDto ) {
    	ManageSalaryDto createdManageSalary = manageSalaryService.createManageSalary(manageSalaryDto);
        logger.info("Created ManageSalary with name: {}", createdManageSalary.getEmployeeFullName());
        return new ResponseEntity<>(createdManageSalary, HttpStatus.CREATED);
    }

    // Get all ManageSalary 
    @GetMapping("/get/managesalary")
    public ResponseEntity<List<ManageSalaryDto>> getAllManageSalary() {
        List<ManageSalaryDto> manageSalary = manageSalaryService.getAllManageSalary();
        logger.info("Retrieved {} ManageSalary from the database", manageSalary.size());
        return new ResponseEntity<>(manageSalary, HttpStatus.OK);
    }

    // Get ManageSalary by ID
    @GetMapping("/get/{manageSalaryId}")
    public ResponseEntity<ManageSalaryDto> getManageSalaryById(@PathVariable Long manageSalaryId) {
        Optional<ManageSalaryDto> manageSalary = manageSalaryService.getManageSalaryById(manageSalaryId);
        if (manageSalary.isPresent()) {
            logger.info("Retrieved ManageSalary with ID: {}", manageSalaryId);
            return new ResponseEntity<>(manageSalary.get(), HttpStatus.OK);
        } else {
            logger.warn("ManageSalary with ID {} not found", manageSalaryId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update ManageSalary by ID
    @PutMapping("/update/{manageSalaryId}")
    public ResponseEntity<ManageSalaryDto> updateManageSalary(@PathVariable Long manageSalaryId, @RequestBody ManageSalaryDto updatedManageSalaryDto) {
    	ManageSalaryDto updatedManageSalary = manageSalaryService.updateManageSalary(manageSalaryId, updatedManageSalaryDto);
        if (updatedManageSalary != null) {
            logger.info("Updated ManageSalary with ID: {}", manageSalaryId);
            return new ResponseEntity<>(updatedManageSalary, HttpStatus.OK);
        } else {
            logger.warn("ManageSalary with ID {} not found for update", manageSalaryId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete ManageSalary by ID
    @DeleteMapping("/delete/{manageSalaryId}")
    public ResponseEntity<Void> deleteManageSalary(@PathVariable Long manageSalaryId) {
  	  manageSalaryService.deleteManageSalary(manageSalaryId);
        logger.info("Deleted ManageSalary with ID: {}", manageSalaryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/managesalary")
	    public long countManageSalary()
	    {
	    	return manageSalaryService.countManageSalary();
	    }
}
