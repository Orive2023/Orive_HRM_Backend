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

import com.orive.Employee.Dto.AwardsDto;
import com.orive.Employee.Service.AwardsService;


@RestController
@RequestMapping(value = "awards")
@CrossOrigin(origins = "*")
public class AwardsController {

	private static final Logger logger = LoggerFactory.getLogger(AwardsController.class);

    @Autowired
    private AwardsService awardsService;

  
  	// Create a new Award
      @PostMapping("/create/awards")
      public ResponseEntity<AwardsDto> createAwards(@RequestBody AwardsDto awardsDto) {
    	  AwardsDto createdAward = awardsService.createAwards(awardsDto);
          logger.info("Created Award with name: {}", createdAward.getAwardName());
          return new ResponseEntity<>(createdAward, HttpStatus.CREATED);
      }

      // Get all Award      
      @GetMapping("/get/awards")
      public ResponseEntity<List<AwardsDto>> getAllAwards() {
          List<AwardsDto> award = awardsService.getAllAwards();
          logger.info("Retrieved {} Award from the database", award.size());
          return new ResponseEntity<>(award, HttpStatus.OK);
      }

      // Get Award by ID
      @GetMapping("/get/{awardId}")
      public ResponseEntity<AwardsDto> getAwardsById(@PathVariable Long awardId) {
          Optional<AwardsDto> award = awardsService.getAwardsById(awardId);
          if (award.isPresent()) {
              logger.info("Retrieved Award with ID: {}", awardId);
              return new ResponseEntity<>(award.get(), HttpStatus.OK);
          } else {
              logger.warn("Award with ID {} not found", awardId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Award by ID
      @PutMapping("/update/{awardId}")
      public ResponseEntity<AwardsDto> updateAwards(@PathVariable Long awardId, @RequestBody AwardsDto updatedAwardsDto) {
    	  AwardsDto updatedAward = awardsService.updateAwards(awardId, updatedAwardsDto);
          if (updatedAward != null) {
              logger.info("Updated Award with ID: {}", awardId);
              return new ResponseEntity<>(updatedAward, HttpStatus.OK);
          } else {
              logger.warn("Award with ID {} not found for update", awardId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Award by ID
      @DeleteMapping("/delete/{awardId}")
      public ResponseEntity<Void> deleteAwards(@PathVariable Long awardId) {
    	  awardsService.deleteAwards(awardId);
          logger.info("Deleted Award with ID: {}", awardId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/awards")
  	    public long countAwards()
  	    {
  	    	return awardsService.countAwards();
  	    }
}
