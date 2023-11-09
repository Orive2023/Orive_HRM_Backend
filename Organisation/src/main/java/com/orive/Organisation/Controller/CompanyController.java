package com.orive.Organisation.Controller;

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

import com.orive.Organisation.Dto.CompanyDto;

import com.orive.Organisation.Service.CompanyService;
@RestController
@RequestMapping(value = "company")
@CrossOrigin(origins = "*")
public class CompanyController {

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

  
  	// Create a new Company
      @PostMapping("/create/company")
      public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
    	  CompanyDto createdCompany = companyService.createCompany(companyDto);
          logger.info("Created company with name: {}", createdCompany.getCompanyName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/company")
      public ResponseEntity<List<CompanyDto>> getAllCompany() {
          List<CompanyDto> companies = companyService.getAllCompany();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{companyId}")
      public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long companyId) {
          Optional<CompanyDto> company = companyService.getCompanyById(companyId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", companyId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", companyId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{companyId}")
      public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long companyId, @RequestBody CompanyDto updatedCompanyDTO) {
    	  CompanyDto updatedCompany = companyService.updateCompany(companyId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", companyId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", companyId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{companyId}")
      public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
    	  companyService.deleteCompany(companyId);
          logger.info("Deleted company with ID: {}", companyId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/company")
  	    public long countCompany()
  	    {
  	    	return companyService.countCompany();
  	    }

}




	

