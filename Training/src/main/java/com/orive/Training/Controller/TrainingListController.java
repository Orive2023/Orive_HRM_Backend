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
import com.orive.Training.Service.TrainingListService;

@RestController
@RequestMapping(value = "traininglist")
@CrossOrigin(origins = "*")
public class TrainingListController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainingListController.class);
	
	@Autowired
	private TrainingListService trainingListService;
	
	// Create a new TrainingList
    @PostMapping("/create/traininglist")
    public ResponseEntity<TrainingListDto> createTrainingList(@RequestBody TrainingListDto trainingListDto) {
    	TrainingListDto createdTrainingList = trainingListService.createTrainingList(trainingListDto);
        logger.info("Created TrainingList with name: {}", createdTrainingList.getEmployeesFullName());
        return new ResponseEntity<>(createdTrainingList, HttpStatus.CREATED);
    }

    // Get all TrainingList   
    @GetMapping("/get/traininglist")
    public ResponseEntity<List<TrainingListDto>> getAllTrainingList() {
        List<TrainingListDto> trainingList = trainingListService.getAllTrainingList();
        logger.info("Retrieved {} TrainingList from the database", trainingList.size());
        return new ResponseEntity<>(trainingList, HttpStatus.OK);
    }

    // Get TrainingList by ID
    @GetMapping("/get/{trainingListId}")
    public ResponseEntity<TrainingListDto> getTrainingListById(@PathVariable Long trainingListId) {
        Optional<TrainingListDto> trainingList = trainingListService.getTrainingListById(trainingListId);
        if (trainingList.isPresent()) {
            logger.info("Retrieved TrainingList with ID: {}", trainingListId);
            return new ResponseEntity<>(trainingList.get(), HttpStatus.OK);
        } else {
            logger.warn("TrainingList with ID {} not found", trainingListId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update TrainingList by ID
    @PutMapping("/update/{trainingListId}")
    public ResponseEntity<TrainingListDto> updateTrainingList(@PathVariable Long trainingListId, @RequestBody TrainingListDto updatedTrainingListDto) {
    	TrainingListDto updatedTrainingList = trainingListService.updateTrainingList(trainingListId, updatedTrainingListDto);
        if (updatedTrainingList != null) {
            logger.info("Updated TrainingList with ID: {}", trainingListId);
            return new ResponseEntity<>(updatedTrainingList, HttpStatus.OK);
        } else {
            logger.warn("TrainingList with ID {} not found for update", trainingListId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete TrainingList by ID
    @DeleteMapping("/delete/{trainingListId}")
    public ResponseEntity<Void> deleteTrainingList(@PathVariable Long trainingListId) {
  	  trainingListService.deleteTrainingList(trainingListId);
        logger.info("Deleted TrainingList with ID: {}", trainingListId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/traininglist")
	    public long countTrainingList()
	    {
	    	return trainingListService.countTrainingList();
	    }
}
