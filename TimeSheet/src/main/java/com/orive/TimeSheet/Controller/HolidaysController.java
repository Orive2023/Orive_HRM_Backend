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

import com.orive.TimeSheet.Dto.HolidaysDto;
import com.orive.TimeSheet.Service.HolidaysService;


@RestController
@RequestMapping(value = "holidays")
public class HolidaysController {

	private static final Logger logger = LoggerFactory.getLogger(HolidaysController.class);

    @Autowired
    private HolidaysService holidaysService;

  
  	// Create a new Company
      @PostMapping("/create/holidays")
      public ResponseEntity<HolidaysDto> createHolidays(@RequestBody HolidaysDto companyDto) {
    	  HolidaysDto createdCompany = holidaysService.createHolidays(companyDto);
          logger.info("Created company with name: {}", createdCompany.getEventName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/holidays")
      public ResponseEntity<List<HolidaysDto>> getAllHolidays() {
          List<HolidaysDto> companies = holidaysService.getAllHolidays();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{holidaysId}")
      public ResponseEntity<HolidaysDto> getHolidaysById(@PathVariable Long holidaysId) {
          Optional<HolidaysDto> company = holidaysService.getHolidaysById(holidaysId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", holidaysId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", holidaysId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{holidaysId}")
      public ResponseEntity<HolidaysDto> updateHolidays(@PathVariable Long holidaysId, @RequestBody HolidaysDto updatedCompanyDTO) {
    	  HolidaysDto updatedCompany = holidaysService.updateHolidays(holidaysId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", holidaysId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", holidaysId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{holidaysId}")
      public ResponseEntity<Void> deleteHolidays(@PathVariable Long holidaysId) {
    	  holidaysService.deleteHolidays(holidaysId);
          logger.info("Deleted company with ID: {}", holidaysId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/holidays")
  	    public long countHolidays()
  	    {
  	    	return holidaysService.countHolidays();
  	    }
}
