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

import com.orive.Organisation.Dto.LocationDto;
import com.orive.Organisation.Service.LocationService;

@RestController
@RequestMapping(value = "location")
public class LocationController {

	private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

  
  	// Create a new Company
      @PostMapping("/create/location")
      public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto companyDto) {
    	  LocationDto createdCompany = locationService.createLocation(companyDto);
          logger.info("Created company with name: {}", createdCompany.getCompanyName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/location")
      public ResponseEntity<List<LocationDto>> getAllLocation() {
          List<LocationDto> companies = locationService.getAllLocation();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{locationId}")
      public ResponseEntity<LocationDto> getLocationById(@PathVariable Long locationId) {
          Optional<LocationDto> company = locationService.getLocationById(locationId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", locationId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", locationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{locationId}")
      public ResponseEntity<LocationDto> updateLocation(@PathVariable Long locationId, @RequestBody LocationDto updatedCompanyDTO) {
    	  LocationDto updatedCompany = locationService.updateLocation(locationId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", locationId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", locationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{locationId}")
      public ResponseEntity<Void> deleteLocation(@PathVariable Long locationId) {
    	  locationService.deleteLocation(locationId);
          logger.info("Deleted company with ID: {}", locationId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/location")
  	    public long countLocation()
  	    {
  	    	return locationService.countLocation();
  	    }
}
