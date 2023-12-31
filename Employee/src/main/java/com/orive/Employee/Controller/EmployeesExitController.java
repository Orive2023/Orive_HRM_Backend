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

import com.orive.Employee.Dto.ComplaintsDto;
import com.orive.Employee.Dto.EmployeesExitDto;
import com.orive.Employee.Service.EmployeesExitService;



@RestController
@RequestMapping(value = "employee_exit")
@CrossOrigin(origins = "*")
public class EmployeesExitController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeesExitController.class);
	
	 @Autowired
	    private EmployeesExitService employeesExitService;
	 
	 
	// Create a new EmployeeExit
	  @PostMapping("/create/employee_exit")
	  public ResponseEntity<EmployeesExitDto> createEmployeesExit(@RequestBody EmployeesExitDto employeesExitDto) {
		  EmployeesExitDto createdEmployeesExit = employeesExitService.createEmployeesExit(employeesExitDto);
	      logger.info("Created EmployeeExit with id: {}", createdEmployeesExit.getEmployeeToExit());
	      return new ResponseEntity<>(createdEmployeesExit, HttpStatus.CREATED);
	  }

	  // Get all EmployeeExit
	  
	  @GetMapping("/get/employee_exit")
	  public ResponseEntity<List<EmployeesExitDto>> getAllEmployeeExit() {
	      List<EmployeesExitDto> employeesExit = employeesExitService.getAllEmployeesExit();
	      logger.info("Retrieved {} EmployeeExit from the database", employeesExit.size());
	      return new ResponseEntity<>(employeesExit, HttpStatus.OK);
	  }

	  // Get EmployeeExit by ID
	  @GetMapping("/get/{employeesExitId}")
	  public ResponseEntity<EmployeesExitDto> getEmployeesExitDtoId(@PathVariable Long employeesExitId) {
	      Optional<EmployeesExitDto> employeesExit = employeesExitService.getEmployeesExitById(employeesExitId);
	      if (employeesExit.isPresent()) {
	          logger.info("Retrieved EmployeeExit with ID: {}", employeesExitId);
	          return new ResponseEntity<>(employeesExit.get(), HttpStatus.OK);
	      } else {
	          logger.warn("EmployeeExit with ID {} not found", employeesExitId);
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	  }

	  // Update EmployeeExit by ID
	  @PutMapping("/update/{employeesExitId}")
	  public ResponseEntity<EmployeesExitDto> updateEmployeesExit(@PathVariable Long employeesExitId, @RequestBody EmployeesExitDto updatedEmployeesExitDto) {
		  EmployeesExitDto updatedEmployeesExit = employeesExitService.updateEmployeesExit(employeesExitId, updatedEmployeesExitDto);
	      if (updatedEmployeesExit != null) {
	          logger.info("Updated EmployeeExit with ID: {}", employeesExitId);
	          return new ResponseEntity<>(updatedEmployeesExit, HttpStatus.OK);
	      } else {
	          logger.warn("EmployeeExit with ID {} not found for update", employeesExitId);
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	  }
	  
	  // Delete EmployeeExit by ID
	  @DeleteMapping("/delete/{employeesExitId}")
	  public ResponseEntity<Void> deleteEmployeesExits(@PathVariable Long employeesExitId) {
		   employeesExitService.deleteEmployeeExit(employeesExitId);
	      logger.info("Deleted EmployeeExit with ID: {}", employeesExitId);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
		    
	  // Count the total EmployeeExit 
		    @GetMapping("/count/employee_exit")
		    public long countEmployeeExit()
		    {
		    	return employeesExitService.countEmployeeExit();
		    }
}
