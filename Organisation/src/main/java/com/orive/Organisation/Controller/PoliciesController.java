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

import com.orive.Organisation.Dto.PoliciesDto;
import com.orive.Organisation.Service.PoliciesService;



@RestController
@RequestMapping(value = "policies")
public class PoliciesController {

	private static final Logger logger = LoggerFactory.getLogger(PoliciesController.class);

    @Autowired
    private PoliciesService policiesService;

  
  	// Create a new Company
      @PostMapping("/create/policies")
      public ResponseEntity<PoliciesDto> createPolicies(@RequestBody PoliciesDto companyDto) {
    	  PoliciesDto createdCompany = policiesService.createPolicies(companyDto);
          logger.info("Created company with name: {}", createdCompany.getCompanyName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/policies")
      public ResponseEntity<List<PoliciesDto>> getAllPolicies() {
          List<PoliciesDto> companies = policiesService.getAllPolicies();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{policiesId}")
      public ResponseEntity<PoliciesDto> getPoliciesById(@PathVariable Long policiesId) {
          Optional<PoliciesDto> company = policiesService.getPoliciesById(policiesId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", policiesId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", policiesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{policiesId}")
      public ResponseEntity<PoliciesDto> updatePolicies(@PathVariable Long policiesId, @RequestBody PoliciesDto updatedCompanyDTO) {
    	  PoliciesDto updatedCompany = policiesService.updatePolicies(policiesId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", policiesId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", policiesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{policiesId}")
      public ResponseEntity<Void> deletePolicies(@PathVariable Long policiesId) {
    	  policiesService.deletePolicies(policiesId);
          logger.info("Deleted company with ID: {}", policiesId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/policies")
  	    public long countPolicies()
  	    {
  	    	return policiesService.countPolicies();
  	    }
}
