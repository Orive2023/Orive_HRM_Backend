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

import com.orive.Organisation.Dto.DesignationDto;
import com.orive.Organisation.Service.DesignationService;



@RestController
@RequestMapping(value = "designation")
@CrossOrigin(origins = "*")
public class DesignationController {

	private static final Logger logger = LoggerFactory.getLogger(DesignationController.class);

    @Autowired
    private DesignationService designationService;

  
  	// Create a new Designation
      @PostMapping("/create/designation")
      public ResponseEntity<DesignationDto> createDesignation(@RequestBody DesignationDto designationDto) {
    	  DesignationDto createdDesignation = designationService.createDesignation(designationDto);
          logger.info("Created Designation with name: {}", createdDesignation.getDesignationName());
          return new ResponseEntity<>(createdDesignation, HttpStatus.CREATED);
      }

      // Get all Designation
      @GetMapping("/get/designation")
      public ResponseEntity<List<DesignationDto>> getAllDesignation() {
          List<DesignationDto> designation = designationService.getAllDesignation();
          logger.info("Retrieved {} Designation from the database", designation.size());
          return new ResponseEntity<>(designation, HttpStatus.OK);
      }

      // Get Designation by ID
      @GetMapping("/get/{designationId}")
      public ResponseEntity<DesignationDto> getDesignationById(@PathVariable Long designationId) {
          Optional<DesignationDto> designation = designationService.getDesignationById(designationId);
          if (designation.isPresent()) {
              logger.info("Retrieved Designation with ID: {}", designationId);
              return new ResponseEntity<>(designation.get(), HttpStatus.OK);
          } else {
              logger.warn("Designation with ID {} not found", designationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Designation by ID
      @PutMapping("/update/{designationId}")
      public ResponseEntity<DesignationDto> updateDesignation(@PathVariable Long designationId, @RequestBody DesignationDto updatedDesignationDto) {
    	  DesignationDto updatedDesignation = designationService.updateDesignation(designationId, updatedDesignationDto);
          if (updatedDesignation != null) {
              logger.info("Updated Designation with ID: {}", designationId);
              return new ResponseEntity<>(updatedDesignation, HttpStatus.OK);
          } else {
              logger.warn("Designation with ID {} not found for update", designationId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      

      // Delete Designation by ID
      @DeleteMapping("/delete/{designationId}")
      public ResponseEntity<Void> deleteDesignation(@PathVariable Long designationId) {
    	  designationService.deleteDesignation(designationId);
          logger.info("Deleted Designation with ID: {}", designationId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      
      
  	  //Count the total Designation
  	    @GetMapping("/count/designation")
  	    public long countDesignation()
  	    {
  	    	return designationService.countDesignation();
  	    }
}
