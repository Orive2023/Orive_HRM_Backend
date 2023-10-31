package com.orive.Organisation.Controller;

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

import com.orive.Organisation.Dto.ExpenceDto;
import com.orive.Organisation.Service.ExpenceService;



@RestController
@RequestMapping(value = "expence")
public class ExpenceController {

	private static final Logger logger = LoggerFactory.getLogger(ExpenceController.class);

    @Autowired
    private ExpenceService expenceService;

  
  	// Create a new Company
      @PostMapping("/create/expence")
      public ResponseEntity<ExpenceDto> createExpence(@RequestBody ExpenceDto companyDto) {
    	  ExpenceDto createdCompany = expenceService.createExpence(companyDto);
          logger.info("Created company with id: {}", createdCompany.getExpenceType());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      @GetMapping("/get/expence")
      public ResponseEntity<List<ExpenceDto>> getAllExpence() {
          List<ExpenceDto> companies = expenceService.getAllExpence();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{expenceId}")
      public ResponseEntity<ExpenceDto> getExpenceById(@PathVariable Long expenceId) {
          Optional<ExpenceDto> company = expenceService.getExpenceById(expenceId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", expenceId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", expenceId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{expenceId}")
      public ResponseEntity<ExpenceDto> updateExpence(@PathVariable Long expenceId, @RequestBody ExpenceDto updatedCompanyDTO) {
    	  ExpenceDto updatedCompany = expenceService.updateExpence(expenceId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", expenceId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", expenceId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      

      // Delete Company by ID
      @DeleteMapping("/delete/{expenceId}")
      public ResponseEntity<Void> deleteExpence(@PathVariable Long expenceId) {
    	  expenceService.deleteExpence(expenceId);
          logger.info("Deleted company with ID: {}", expenceId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/expence")
  	    public long countExpence()
  	    {
  	    	return expenceService.countExpence();
  	    }
}
