package com.orive.Training.Controller;

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

import com.orive.Training.Dto.TrainingListDto;
import com.orive.Training.Dto.TrainingTypeDto;
import com.orive.Training.Service.TrainingTypeService;



@RestController
@RequestMapping(value = "trainingtype")
@CrossOrigin(origins = "*")
public class TrainingTypeController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainingTypeController.class);
	
	@Autowired
	private TrainingTypeService trainingTypeService;
	
	// Create a new TrainingType
    @PostMapping("/create/trainingtype")
    public ResponseEntity<TrainingTypeDto> createTrainingType(@RequestBody TrainingTypeDto trainingTypeDto) {
    	TrainingTypeDto createdTrainingType = trainingTypeService.createTrainingType(trainingTypeDto);
        logger.info("Created TrainingType with name: {}", createdTrainingType.getWorkshop());
        return new ResponseEntity<>(createdTrainingType, HttpStatus.CREATED);
    }

    // Get all TrainingType   
    @GetMapping("/get/trainingtype")
    public ResponseEntity<List<TrainingTypeDto>> getAllTrainingType() {
        List<TrainingTypeDto> trainingType = trainingTypeService.getAllTrainingType();
        logger.info("Retrieved {} TrainingType from the database", trainingType.size());
        return new ResponseEntity<>(trainingType, HttpStatus.OK);
    }

    // Get TrainingType by ID
    @GetMapping("/get/{trainingTypeId}")
    public ResponseEntity<TrainingTypeDto> getTrainingTypeById(@PathVariable Long trainingTypeId) {
        Optional<TrainingTypeDto> trainingType = trainingTypeService.getTrainingTypeById(trainingTypeId);
        if (trainingType.isPresent()) {
            logger.info("Retrieved TrainingType with ID: {}", trainingTypeId);
            return new ResponseEntity<>(trainingType.get(), HttpStatus.OK);
        } else {
            logger.warn("TrainingType with ID {} not found", trainingTypeId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update TrainingType by ID
    @PutMapping("/update/{trainingTypeId}")
    public ResponseEntity<TrainingTypeDto> updateTrainingType(@PathVariable Long trainingTypeId, @RequestBody TrainingTypeDto updatedTrainingTypeDto) {
    	TrainingTypeDto updatedTrainingType = trainingTypeService.updateTrainingType(trainingTypeId, updatedTrainingTypeDto);
        if (updatedTrainingType != null) {
            logger.info("Updated TrainingType with ID: {}", trainingTypeId);
            return new ResponseEntity<>(updatedTrainingType, HttpStatus.OK);
        } else {
            logger.warn("TrainingType with ID {} not found for update", trainingTypeId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete TrainingType by ID
    @DeleteMapping("/delete/{trainingTypeId}")
    public ResponseEntity<Void> deleteTrainingType(@PathVariable Long trainingTypeId) {
  	  trainingTypeService.deleteTrainingType(trainingTypeId);
        logger.info("Deleted TrainingType with ID: {}", trainingTypeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/trainingtype")
	    public long countTrainingType()
	    {
	    	return trainingTypeService.countTrainingType();
	    }
}
