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

import com.orive.Organisation.Dto.DesignationDto;
import com.orive.Organisation.Service.DesignationService;



@RestController
@RequestMapping(value = "designation")
public class DesignationController {

	private static final Logger logger = LoggerFactory.getLogger(DesignationController.class);

    @Autowired
    private DesignationService designationService;

  
  	// Create a new Company
      @PostMapping("/create/designation")
      public ResponseEntity<DesignationDto> createDesignation(@RequestBody DesignationDto companyDto) {
    	  DesignationDto createdCompany = designationService.createDesignation(companyDto);
          logger.info("Created company with name: {}", createdCompany.getDesignationName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      @GetMapping("/get/designation")
      public ResponseEntity<List<DesignationDto>> getAllDesignation() {
          List<DesignationDto> companies = designationService.getAllDesignation();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{designationId}")
      public ResponseEntity<DesignationDto> getDesignationById(@PathVariable Long designationId) {
          Optional<DesignationDto> company = designationService.getDesignationById(designationId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", designationId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", designationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{designationId}")
      public ResponseEntity<DesignationDto> updateDesignation(@PathVariable Long designationId, @RequestBody DesignationDto updatedCompanyDTO) {
    	  DesignationDto updatedCompany = designationService.updateDesignation(designationId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", designationId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", designationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      

      // Delete Company by ID
      @DeleteMapping("/delete/{designationId}")
      public ResponseEntity<Void> deleteDesignation(@PathVariable Long designationId) {
    	  designationService.deleteDesignation(designationId);
          logger.info("Deleted company with ID: {}", designationId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/designation")
  	    public long countDesignation()
  	    {
  	    	return designationService.countDesignation();
  	    }
}
