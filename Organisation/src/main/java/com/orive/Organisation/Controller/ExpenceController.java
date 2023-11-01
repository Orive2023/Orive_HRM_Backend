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

import com.orive.Organisation.Dto.ExpenceDto;
import com.orive.Organisation.Service.ExpenceService;



@RestController
@RequestMapping(value = "expence")
public class ExpenceController {

	private static final Logger logger = LoggerFactory.getLogger(ExpenceController.class);

    @Autowired
    private ExpenceService expenceService;

  
  	// Create a new Expence
      @PostMapping("/create/expence")
      public ResponseEntity<ExpenceDto> createExpence(@RequestBody ExpenceDto expenceDto) {
    	  ExpenceDto createdExpence = expenceService.createExpence(expenceDto);
          logger.info("Created Expence with id: {}", createdExpence.getExpenceType());
          return new ResponseEntity<>(createdExpence, HttpStatus.CREATED);
      }

      // Get all Expence
      @GetMapping("/get/expence")
      public ResponseEntity<List<ExpenceDto>> getAllExpence() {
          List<ExpenceDto> expence = expenceService.getAllExpence();
          logger.info("Retrieved {} Expence from the database", expence.size());
          return new ResponseEntity<>(expence, HttpStatus.OK);
      }

      // Get Expence by ID
      @GetMapping("/get/{expenceId}")
      public ResponseEntity<ExpenceDto> getExpenceById(@PathVariable Long expenceId) {
          Optional<ExpenceDto> expence = expenceService.getExpenceById(expenceId);
          if (expence.isPresent()) {
              logger.info("Retrieved Expence with ID: {}", expenceId);
              return new ResponseEntity<>(expence.get(), HttpStatus.OK);
          } else {
              logger.warn("Expence with ID {} not found", expenceId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Expence by ID
      @PutMapping("/update/{expenceId}")
      public ResponseEntity<ExpenceDto> updateExpence(@PathVariable Long expenceId, @RequestBody ExpenceDto updatedExpenceDto) {
    	  ExpenceDto updatedExpence = expenceService.updateExpence(expenceId, updatedExpenceDto);
          if (updatedExpence != null) {
              logger.info("Updated Expence with ID: {}", expenceId);
              return new ResponseEntity<>(updatedExpence, HttpStatus.OK);
          } else {
              logger.warn("Expence with ID {} not found for update", expenceId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      

      // Delete Expence by ID
      @DeleteMapping("/delete/{expenceId}")
      public ResponseEntity<Void> deleteExpence(@PathVariable Long expenceId) {
    	  expenceService.deleteExpence(expenceId);
          logger.info("Deleted Expence with ID: {}", expenceId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/expence")
  	    public long countExpence()
  	    {
  	    	return expenceService.countExpence();
  	    }
}
