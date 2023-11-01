package com.orive.Employee.Controller;

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

import com.orive.Employee.Dto.EmployeesDto;
import com.orive.Employee.Service.EmployeesService;


@RestController
@RequestMapping(value = "employee")
public class EmployeesController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

    @Autowired
    private EmployeesService employeesService;

  
  	// Create a new Employees
      @PostMapping("/create/employee")
      public ResponseEntity<EmployeesDto> createEmployees(@RequestBody EmployeesDto employeesDto) {
    	  EmployeesDto createdEmployees = employeesService.createEmployees(employeesDto);
          logger.info("Created Employees with name: {}", createdEmployees.getEmployeeName());
          return new ResponseEntity<>(createdEmployees, HttpStatus.CREATED);
      }

      // Get all Employees
      
      @GetMapping("/get/employee")
      public ResponseEntity<List<EmployeesDto>> getAllEmployees() {
          List<EmployeesDto> employee = employeesService.getAllEmployees();
          logger.info("Retrieved {} Employees from the database", employee.size());
          return new ResponseEntity<>(employee, HttpStatus.OK);
      }

      // Get Employees by ID
      @GetMapping("/get/{employeeId}")
      public ResponseEntity<EmployeesDto> getEmployeesById(@PathVariable Long employeeId) {
          Optional<EmployeesDto> employee = employeesService.getEmployeesById(employeeId);
          if (employee.isPresent()) {
              logger.info("Retrieved Employees with ID: {}", employeeId);
              return new ResponseEntity<>(employee.get(), HttpStatus.OK);
          } else {
              logger.warn("Employees with ID {} not found", employeeId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Employees by ID
      @PutMapping("/update/{employeeId}")
      public ResponseEntity<EmployeesDto> updateEmployees(@PathVariable Long employeeId, @RequestBody EmployeesDto updatedEmployeesDto) {
    	  EmployeesDto updatedEmployees = employeesService.updateEmployees(employeeId, updatedEmployeesDto);
          if (updatedEmployees != null) {
              logger.info("Updated Employees with ID: {}", employeeId);
              return new ResponseEntity<>(updatedEmployees, HttpStatus.OK);
          } else {
              logger.warn("Employees with ID {} not found for update", employeeId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Employees by ID
      @DeleteMapping("/delete/{employeeId}")
      public ResponseEntity<Void> deleteEmployees(@PathVariable Long employeeId) {
    	  employeesService.deleteEmployees(employeeId);
          logger.info("Deleted Employees with ID: {}", employeeId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/employee")
  	    public long countEmployees()
  	    {
  	    	return employeesService.countEmployees();
  	    }
}
