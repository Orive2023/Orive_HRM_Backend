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

import com.orive.Organisation.Dto.LocationDto;
import com.orive.Organisation.Entity.LocationEntity;
import com.orive.Organisation.Exceptions.ResourceNotFoundException;
import com.orive.Organisation.Service.LocationService;

@RestController
@RequestMapping(value = "location")
@CrossOrigin(origins = "*")
public class LocationController {

	private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

  
  	// Create a new Location
      @PostMapping("/create/location")
      public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
    	  LocationDto createdLocation = locationService.createLocation(locationDto);
          logger.info("Created Location with name: {}", createdLocation.getCompanyName());
          return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
      }

      // Get all Location  
      @GetMapping("/get/location")
      public ResponseEntity<List<LocationDto>> getAllLocation() {
          List<LocationDto> location = locationService.getAllLocation();
          logger.info("Retrieved {} Location from the database", location.size());
          return new ResponseEntity<>(location, HttpStatus.OK);
      }

      // Get Location by ID
      @GetMapping("/get/{locationId}")
      public ResponseEntity<LocationDto> getLocationById(@PathVariable Long locationId) {
          Optional<LocationDto> location = locationService.getLocationById(locationId);
          if (location.isPresent()) {
              logger.info("Retrieved Location with ID: {}", locationId);
              return new ResponseEntity<>(location.get(), HttpStatus.OK);
          } else {
              logger.warn("Location with ID {} not found", locationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      
      // Get the Location by company name
  	  @GetMapping("/{companyName}")
      public ResponseEntity<List<LocationEntity>> getLocationsByCompanyName(@PathVariable String companyName) {
          try {
        	  logger.info("Request to get locations for company: " + companyName);
              List<LocationEntity> locations = locationService.getAllLocationsByCompanyName(companyName);
              logger.info("Returned " + locations.size() + " locations for company: " + companyName);
              return ResponseEntity.ok(locations);
          } catch (ResourceNotFoundException e) {
        	  logger.warn("No locations found for company: " + companyName);
              throw e;
          } catch (Exception e) {
        	  logger.error("Error occurred while processing the request for company: {}", companyName, e);
              throw e; // You might want to handle this differently based on your use case
          }
      }

      // Update Location by ID
      @PutMapping("/update/{locationId}")
      public ResponseEntity<LocationDto> updateLocation(@PathVariable Long locationId, @RequestBody LocationDto updatedLocationDto) {
    	  LocationDto updatedLocation = locationService.updateLocation(locationId, updatedLocationDto);
          if (updatedLocation != null) {
              logger.info("Updated Location with ID: {}", locationId);
              return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
          } else {
              logger.warn("Location with ID {} not found for update", locationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Location by ID
      @DeleteMapping("/delete/{locationId}")
      public ResponseEntity<Void> deleteLocation(@PathVariable Long locationId) {
    	  locationService.deleteLocation(locationId);
          logger.info("Deleted Location with ID: {}", locationId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      
      //Count the total Location 
  	    @GetMapping("/count/location")
  	    public long countLocation()
  	    {
  	    	return locationService.countLocation();
  	    }
  	    
  	  
}
