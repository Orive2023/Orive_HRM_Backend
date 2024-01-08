package com.orive.WorkSheet.Controller;

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


import com.orive.WorkSheet.Dto.WorkSheetDto;
import com.orive.WorkSheet.Service.WorkSheetService;

@RestController
@RequestMapping(value = "worksheet")
@CrossOrigin(origins = "*")
public class WorkSheetController {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkSheetController.class);
	
	@Autowired
	private WorkSheetService workSheetService;
	
	// Create a new WorkSheet
		  @PostMapping("/create/worksheet")
		  public ResponseEntity<WorkSheetDto> createWorkSheet(@RequestBody WorkSheetDto workSheetDto) {
			  WorkSheetDto createdWorkSheet = workSheetService.createWorkSheet(workSheetDto);
		      logger.info("Created WorkSheet with id: {}", createdWorkSheet.getWorkSheetTitle());
		      return new ResponseEntity<>(createdWorkSheet, HttpStatus.CREATED);
		  }

		  
		  // Get all WorkSheet  
		  @GetMapping("/get/worksheet")
		  public ResponseEntity<List<WorkSheetDto>> getAllWorkSheets() {
		      List<WorkSheetDto> workSheet = workSheetService.getAllWorkSheets();
		      logger.info("Retrieved {} WorkSheet from the database", workSheet.size());
		      return new ResponseEntity<>(workSheet, HttpStatus.OK);
		  }

		  // Get WorkSheet by ID
		  @GetMapping("/get/{workSheetId}")
		  public ResponseEntity<WorkSheetDto> getWorkSheetDtoId(@PathVariable Long workSheetId) {
		      Optional<WorkSheetDto> workSheet = workSheetService.getWorkSheetId(workSheetId);
		      if (workSheet.isPresent()) {
		          logger.info("Retrieved WorkSheet with ID: {}", workSheetId);
		          return new ResponseEntity<>(workSheet.get(), HttpStatus.OK);
		      } else {
		          logger.warn("WorkSheet with ID {} not found", workSheetId);
		          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		      }
		  }
		  
		  
		// Get Employee by ID
		  @GetMapping("/{employeeId}")
		    public ResponseEntity<List<WorkSheetDto>> getWorkSheetsByEmployeeId(@PathVariable Long employeeId) {
		        List<WorkSheetDto> workSheet = workSheetService.getEmployeeId(employeeId);

		        if (workSheet.isEmpty()) {
		            return ResponseEntity.notFound().build();
		        } else {
		            return ResponseEntity.ok(workSheet);
		        }
		    }
		  
		  
		  
		  // Update WorkSheet by ID
		  @PutMapping("/update/{workSheetId}")
		  public ResponseEntity<WorkSheetDto> updateWorkSheet(@PathVariable Long workSheetId, @RequestBody WorkSheetDto updatedWorkSheetDto) {
			  WorkSheetDto updatedWorkSheet = workSheetService.updateWorkSheet(workSheetId, updatedWorkSheetDto);
		      if (updatedWorkSheet != null) {
		          logger.info("Updated WorkSheet with ID: {}", workSheetId);
		          return new ResponseEntity<>(updatedWorkSheet, HttpStatus.OK);
		      } else {
		          logger.warn("WorkSheet with ID {} not found for update", updatedWorkSheet);
		          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		      }
		  }
		  
		  // Delete WorkSheet by ID
		  @DeleteMapping("/delete/{workSheetId}")
		  public ResponseEntity<Void> deleteWorkSheet(@PathVariable Long workSheetId) {
			   workSheetService.deleteWorkSheet(workSheetId);
		      logger.info("Deleted WorkSheet with ID: {}", workSheetId);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
			    
			    @GetMapping("/count/worksheet")
			    public long countWorkSheet()
			    {
			    	return workSheetService.countWorkSheet();
			    }


}
