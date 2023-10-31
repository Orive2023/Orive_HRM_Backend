package com.orive.Performance.Controller;

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

import com.orive.Performance.Dto.PerformanceIndicatorDto;
import com.orive.Performance.Service.PerformanceIndicatorService;

@RestController
@RequestMapping(value = "performanceindicator")
public class PerformanceIndicatorController {
	
	private static final Logger logger= LoggerFactory.getLogger(PerformanceIndicatorController.class);
	
	@Autowired
	private PerformanceIndicatorService performanceIndicatorService;
	
	// Create a new PerformanceIndicator
    @PostMapping("/create/performanceindicator")
    public ResponseEntity<PerformanceIndicatorDto> createPerformanceIndicator(@RequestBody PerformanceIndicatorDto performanceIndicatorDto) {
    	PerformanceIndicatorDto createdPerformanceIndicator = performanceIndicatorService.createPerformanceIndicator(performanceIndicatorDto);
        logger.info("Created PerformanceIndicator with name: {}", createdPerformanceIndicator.getEmployeeName());
        return new ResponseEntity<>(createdPerformanceIndicator, HttpStatus.CREATED);
    }

    // Get all PerformanceIndicator    
    @GetMapping("/get/performanceindicator")
    public ResponseEntity<List<PerformanceIndicatorDto>> getAllPerformanceIndicator() {
        List<PerformanceIndicatorDto> performanceIndicator = performanceIndicatorService.getAllPerformanceIndicator();
        logger.info("Retrieved {} PerformanceIndicator from the database", performanceIndicator.size());
        return new ResponseEntity<>(performanceIndicator, HttpStatus.OK);
    }

    // Get PerformanceIndicatorbyId
    @GetMapping("/get/{performanceIndicatorId}")
    public ResponseEntity<PerformanceIndicatorDto> getPerformanceIndicatorbyId(@PathVariable Long performanceIndicatorId) {
        Optional<PerformanceIndicatorDto> performanceIndicator = performanceIndicatorService.getPerformanceIndicatorById(performanceIndicatorId);
        if (performanceIndicator.isPresent()) {
            logger.info("Retrieved PerformanceIndicator with ID: {}", performanceIndicatorId);
            return new ResponseEntity<>(performanceIndicator.get(), HttpStatus.OK);
        } else {
            logger.warn("PerformanceIndicator with ID {} not found", performanceIndicatorId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update PerformanceIndicator by ID
    @PutMapping("/update/{performanceIndicatorId}")
    public ResponseEntity<PerformanceIndicatorDto> updatePerformanceIndicator(@PathVariable Long performanceIndicatorId, @RequestBody PerformanceIndicatorDto updatedPerformanceIndicatorDto) {
    	PerformanceIndicatorDto updatedPerformanceIndicator = performanceIndicatorService.updatePerformanceIndicator(performanceIndicatorId, updatedPerformanceIndicatorDto);
        if (updatedPerformanceIndicator != null) {
            logger.info("Updated PerformanceIndicator with ID: {}", performanceIndicatorId);
            return new ResponseEntity<>(updatedPerformanceIndicator, HttpStatus.OK);
        } else {
            logger.warn("PerformanceIndicator with ID {} not found for update", performanceIndicatorId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete PerformanceIndicator by ID
    @DeleteMapping("/delete/{performanceIndicatorId}")
    public ResponseEntity<Void> deletePerformanceIndicator(@PathVariable Long performanceIndicatorId) {
  	  performanceIndicatorService.deletePerformanceIndicator(performanceIndicatorId);
        logger.info("Deleted PerformanceIndicator with ID: {}", performanceIndicatorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/performanceindicator")
	    public long countPerformanceIndicator()
	    {
	    	return performanceIndicatorService.countPerformanceIndicator();
	    }


}
