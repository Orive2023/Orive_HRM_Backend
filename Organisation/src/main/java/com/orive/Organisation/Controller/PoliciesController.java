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

import com.orive.Organisation.Dto.PoliciesDto;
import com.orive.Organisation.Service.PoliciesService;



@RestController
@RequestMapping(value = "policies")
@CrossOrigin(origins = "*")
public class PoliciesController {

	private static final Logger logger = LoggerFactory.getLogger(PoliciesController.class);

    @Autowired
    private PoliciesService policiesService;

  
  	// Create a new Policies
      @PostMapping("/create/policies")
      public ResponseEntity<PoliciesDto> createPolicies(@RequestBody PoliciesDto policiesDto) {
    	  PoliciesDto createdPolicies = policiesService.createPolicies(policiesDto);
          logger.info("Created Policies with name: {}", createdPolicies.getCompanyName());
          return new ResponseEntity<>(createdPolicies, HttpStatus.CREATED);
      }

      // Get all Policies  
      @GetMapping("/get/policies")
      public ResponseEntity<List<PoliciesDto>> getAllPolicies() {
          List<PoliciesDto> policies = policiesService.getAllPolicies();
          logger.info("Retrieved {} Policies from the database", policies.size());
          return new ResponseEntity<>(policies, HttpStatus.OK);
      }

      // Get Policies by ID
      @GetMapping("/get/{policiesId}")
      public ResponseEntity<PoliciesDto> getPoliciesById(@PathVariable Long policiesId) {
          Optional<PoliciesDto> policies = policiesService.getPoliciesById(policiesId);
          if (policies.isPresent()) {
              logger.info("Retrieved Policies with ID: {}", policiesId);
              return new ResponseEntity<>(policies.get(), HttpStatus.OK);
          } else {
              logger.warn("Policies with ID {} not found", policiesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Policies by ID
      @PutMapping("/update/{policiesId}")
      public ResponseEntity<PoliciesDto> updatePolicies(@PathVariable Long policiesId, @RequestBody PoliciesDto updatedPoliciesDto) {
    	  PoliciesDto updatedPolicies = policiesService.updatePolicies(policiesId, updatedPoliciesDto);
          if (updatedPolicies != null) {
              logger.info("Updated Policies with ID: {}", policiesId);
              return new ResponseEntity<>(updatedPolicies, HttpStatus.OK);
          } else {
              logger.warn("Policies with ID {} not found for update", policiesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Policies by ID
      @DeleteMapping("/delete/{policiesId}")
      public ResponseEntity<Void> deletePolicies(@PathVariable Long policiesId) {
    	  policiesService.deletePolicies(policiesId);
          logger.info("Deleted Policies with ID: {}", policiesId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/policies")
  	    public long countPolicies()
  	    {
  	    	return policiesService.countPolicies();
  	    }
}
