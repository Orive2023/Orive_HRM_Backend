package com.orive.Performance.Controller;

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

import com.orive.Performance.Dto.PerformanceAppraisalDto;
import com.orive.Performance.Service.PerformanceAppraisalService;

@RestController
@RequestMapping(value = "performanceappraisal")
@CrossOrigin(origins = "http://localhost:3000")
public class PerformanceAppraisalController {

	
	private static final Logger logger = LoggerFactory.getLogger(PerformanceAppraisalController.class);

    @Autowired
    private PerformanceAppraisalService performanceAppraisalService;
    
    
 // Create a new PerformanceAppraisal
    @PostMapping("/create/performanceappraisal")
    public ResponseEntity<PerformanceAppraisalDto> createPerformanceAppraisal(@RequestBody PerformanceAppraisalDto performanceAppraisalDto) {
    	PerformanceAppraisalDto createdPerformanceAppraisal = performanceAppraisalService.createPerformanceAppraisal(performanceAppraisalDto);
        logger.info("Created PerformanceAppraisal with name: {}", createdPerformanceAppraisal.getEmployeeName());
        return new ResponseEntity<>(createdPerformanceAppraisal, HttpStatus.CREATED);
    }

    // Get all PerformanceAppraisal
    
    @GetMapping("/get/performanceappraisal")
    public ResponseEntity<List<PerformanceAppraisalDto>> getAllPerformanceAppraisal() {
        List<PerformanceAppraisalDto> performanceAppraisal = performanceAppraisalService.getAllPerformanceAppraisal();
        logger.info("Retrieved {} PerformanceAppraisal from the database", performanceAppraisal.size());
        return new ResponseEntity<>(performanceAppraisal, HttpStatus.OK);
    }

    // Get PerformanceAppraisalbyId
    @GetMapping("/get/{performanceAppraisalId}")
    public ResponseEntity<PerformanceAppraisalDto> getPerformanceAppraisalbyId(@PathVariable Long performanceAppraisalId) {
        Optional<PerformanceAppraisalDto> performanceAppraisal = performanceAppraisalService.getPerformanceAppraisalById(performanceAppraisalId);
        if (performanceAppraisal.isPresent()) {
            logger.info("Retrieved PerformanceAppraisal with ID: {}", performanceAppraisalId);
            return new ResponseEntity<>(performanceAppraisal.get(), HttpStatus.OK);
        } else {
            logger.warn("PerformanceAppraisal with ID {} not found", performanceAppraisalId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update PerformanceAppraisal by ID
    @PutMapping("/update/{performanceAppraisalId}")
    public ResponseEntity<PerformanceAppraisalDto> updatePerformanceAppraisal(@PathVariable Long performanceAppraisalId, @RequestBody PerformanceAppraisalDto updatedPerformanceAppraisalDto) {
    	PerformanceAppraisalDto updatedPerformanceAppraisal = performanceAppraisalService.updatePerformanceAppraisal(performanceAppraisalId, updatedPerformanceAppraisalDto);
        if (updatedPerformanceAppraisal != null) {
            logger.info("Updated PerformanceAppraisal with ID: {}", performanceAppraisalId);
            return new ResponseEntity<>(updatedPerformanceAppraisal, HttpStatus.OK);
        } else {
            logger.warn("PerformanceAppraisal with ID {} not found for update", performanceAppraisalId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete PerformanceAppraisal by ID
    @DeleteMapping("/delete/{performanceAppraisalId}")
    public ResponseEntity<Void> deletePerformanceAppraisal(@PathVariable Long performanceAppraisalId) {
  	  performanceAppraisalService.deletePerformanceAppraisal(performanceAppraisalId);
        logger.info("Deleted PerformanceAppraisal with ID: {}", performanceAppraisalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/performanceappraisal")
	    public long countPerformanceAppraisal()
	    {
	    	return performanceAppraisalService.countPerformanceAppraisal();
	    }
}
