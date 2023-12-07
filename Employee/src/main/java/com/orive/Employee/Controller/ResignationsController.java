package com.orive.Employee.Controller;

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

import com.orive.Employee.Dto.ResignationsDto;
import com.orive.Employee.Service.ResignationsService;

@RestController
@RequestMapping(value = "resignations")
@CrossOrigin(origins = "*")
public class ResignationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResignationsController.class);
	
	 @Autowired
	    private ResignationsService resignationsService;
	 
	// Create a new Resignation
     @PostMapping("/create/resignations")
     public ResponseEntity<ResignationsDto> createResignations(@RequestBody ResignationsDto resignationsDto) {
    	 ResignationsDto createdResignation = resignationsService.createResignations(resignationsDto);
         logger.info("Created resignations with id: {}", createdResignation.getEmployeeName());
         return new ResponseEntity<>(createdResignation, HttpStatus.CREATED);
     }

     // Get all Resignations
     
     @GetMapping("/get/resignations")
     public ResponseEntity<List<ResignationsDto>> getAllResignations() {
         List<ResignationsDto> resignations = resignationsService.getAllResignations();
         logger.info("Retrieved {} resignations from the database", resignations.size());
         return new ResponseEntity<>(resignations, HttpStatus.OK);
     }

     // Get resignation by ID
     @GetMapping("/get/{resignationId}")
     public ResponseEntity<ResignationsDto> getResignationId(@PathVariable Long resignationId) {
         Optional<ResignationsDto> resignations = resignationsService.getResignationsById(resignationId);
         if (resignations.isPresent()) {
             logger.info("Retrieved resignations with ID: {}", resignationId);
             return new ResponseEntity<>(resignations.get(), HttpStatus.OK);
         } else {
             logger.warn("resignations with ID {} not found", resignationId);
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }

     // Update resignation by ID
     @PutMapping("/update/{resignationId}")
     public ResponseEntity<ResignationsDto> updateResignations(@PathVariable Long resignationId, @RequestBody ResignationsDto updatedResignationsDTO) {
    	 ResignationsDto updatedResignations = resignationsService.updateResignations(resignationId, updatedResignationsDTO);
         if (updatedResignations != null) {
             logger.info("Updated resignations with ID: {}", resignationId);
             return new ResponseEntity<>(updatedResignations, HttpStatus.OK);
         } else {
             logger.warn("Resignations with ID {} not found for update", resignationId);
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }
     


     // Delete Resignation by ID
     @DeleteMapping("/delete/{resignationId}")
     public ResponseEntity<Void> deleteResignations(@PathVariable Long resignationId) {
    	 resignationsService.deleteResignations(resignationId);
         logger.info("Deleted Resignations with ID: {}", resignationId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
 	    
  // Count the total  Resignation
 	    @GetMapping("/count/resignations")
 	    public long countResignations()
 	    {
 	    	return resignationsService.countResignations();
 	    }
}
