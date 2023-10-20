package com.orive.Employee.Controller;

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

import com.orive.Employee.Dto.AwardsDto;
import com.orive.Employee.Service.AwardsService;


@RestController
@RequestMapping(value = "awards")
public class AwardsController {

	private static final Logger logger = LoggerFactory.getLogger(AwardsController.class);

    @Autowired
    private AwardsService awardsService;

  
  	// Create a new Company
      @PostMapping("/create/awards")
      public ResponseEntity<AwardsDto> createAwards(@RequestBody AwardsDto companyDto) {
    	  AwardsDto createdCompany = awardsService.createAwards(companyDto);
          logger.info("Created company with name: {}", createdCompany.getAwardName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/awards")
      public ResponseEntity<List<AwardsDto>> getAllAwards() {
          List<AwardsDto> companies = awardsService.getAllAwards();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{awardId}")
      public ResponseEntity<AwardsDto> getAwardsById(@PathVariable Long awardId) {
          Optional<AwardsDto> company = awardsService.getAwardsById(awardId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", awardId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", awardId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{awardId}")
      public ResponseEntity<AwardsDto> updateAwards(@PathVariable Long awardId, @RequestBody AwardsDto updatedCompanyDTO) {
    	  AwardsDto updatedCompany = awardsService.updateAwards(awardId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", awardId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", awardId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{awardId}")
      public ResponseEntity<Void> deleteAwards(@PathVariable Long awardId) {
    	  awardsService.deleteAwards(awardId);
          logger.info("Deleted company with ID: {}", awardId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/awards")
  	    public long countAwards()
  	    {
  	    	return awardsService.countAwards();
  	    }
}
