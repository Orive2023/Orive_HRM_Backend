package com.orive.TimeSheet.Controller;

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

import com.orive.TimeSheet.Dto.OfficeShiftsDto;
import com.orive.TimeSheet.Service.OfficeShiftsService;


@RestController
@RequestMapping(value = "officeshifts")
public class OfficeShiftsController {

	private static final Logger logger = LoggerFactory.getLogger(OfficeShiftsController.class);

    @Autowired
    private OfficeShiftsService officeShiftsService;

  
  	// Create a new Company
      @PostMapping("/create/officeShifts")
      public ResponseEntity<OfficeShiftsDto> createOfficeShifts(@RequestBody OfficeShiftsDto companyDto) {
    	  OfficeShiftsDto createdCompany = officeShiftsService.createOfficeShifts(companyDto);
          logger.info("Created company with name: {}", createdCompany.getShiftName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/officeShifts")
      public ResponseEntity<List<OfficeShiftsDto>> getAllOfficeShifts() {
          List<OfficeShiftsDto> companies = officeShiftsService.getAllOfficeShifts();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{OfficeShiftsId}")
      public ResponseEntity<OfficeShiftsDto> getOfficeShiftsById(@PathVariable Long OfficeShiftsId) {
          Optional<OfficeShiftsDto> company = officeShiftsService.getOfficeShiftsById(OfficeShiftsId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", OfficeShiftsId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", OfficeShiftsId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{OfficeShiftsId}")
      public ResponseEntity<OfficeShiftsDto> updateOfficeShifts(@PathVariable Long OfficeShiftsId, @RequestBody OfficeShiftsDto updatedCompanyDTO) {
    	  OfficeShiftsDto updatedCompany = officeShiftsService.updateOfficeShifts(OfficeShiftsId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", OfficeShiftsId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", OfficeShiftsId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{OfficeShiftsId}")
      public ResponseEntity<Void> deleteOfficeShifts(@PathVariable Long OfficeShiftsId) {
    	  officeShiftsService.deleteOfficeShifts(OfficeShiftsId);
          logger.info("Deleted company with ID: {}", OfficeShiftsId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/officeShifts")
  	    public long countOfficeShifts()
  	    {
  	    	return officeShiftsService.countOfficeShifts();
  	    }
}
