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

import com.orive.Employee.Dto.EmployeesLastLoginDto;
import com.orive.Employee.Dto.WarningsDto;
import com.orive.Employee.Service.EmployeesLastLoginService;



@RestController
@RequestMapping(value = "employees_last_login")
public class EmployeeLastLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeLastLoginController.class);
	
	 @Autowired
	    private EmployeesLastLoginService employeesLastLoginService;
	 
	 
	// Create a new EmployeeLastLogin
		  @PostMapping("/create/employees_last_login")
		  public ResponseEntity<EmployeesLastLoginDto> createEmployeesLastLogin(@RequestBody EmployeesLastLoginDto employeesLastLoginDto) {
			  EmployeesLastLoginDto createdEmployeesLastLogin = employeesLastLoginService.createEmployeesLastLogin(employeesLastLoginDto);
		      logger.info("Created EmployeeLastLogin with id: {}", createdEmployeesLastLogin.getEmployeeLastLoginId());
		      return new ResponseEntity<>(createdEmployeesLastLogin, HttpStatus.CREATED);
		  }

		  // Get all EmployeeLastLogin
		  
		  @GetMapping("/get/employees_last_login")
		  public ResponseEntity<List<EmployeesLastLoginDto>> getAllEmployeesLastLogins() {
		      List<EmployeesLastLoginDto> employeesLastLogin = employeesLastLoginService.getAllEmployeeLastLogin();
		      logger.info("Retrieved {} EmployeeLastLogin from the database", employeesLastLogin.size());
		      return new ResponseEntity<>(employeesLastLogin, HttpStatus.OK);
		  }

		  // Get EmployeeLastLogin by ID
		  @GetMapping("/get/{employeesLastLoginId}")
		  public ResponseEntity<EmployeesLastLoginDto> getEmployeesLastLoginDtoId(@PathVariable Long employeesLastLoginId) {
		      Optional<EmployeesLastLoginDto> employeesLastLogins = employeesLastLoginService.getEmployeesLastLoginById(employeesLastLoginId);
		      if (employeesLastLogins.isPresent()) {
		          logger.info("Retrieved EmployeeLastLogin with ID: {}", employeesLastLoginId);
		          return new ResponseEntity<>(employeesLastLogins.get(), HttpStatus.OK);
		      } else {
		          logger.warn("EmployeeLastLogin with ID {} not found", employeesLastLoginId);
		          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		      }
		  }

		  // Update EmployeeLastLogin by ID
		  @PutMapping("/update/{employeesLastLoginId}")
		  public ResponseEntity<EmployeesLastLoginDto> updateEmployeesLastLogins(@PathVariable Long employeesLastLoginId, @RequestBody EmployeesLastLoginDto updatedEmployeesLastLoginDto) {
			  EmployeesLastLoginDto updatedEmployeesLastLogins = employeesLastLoginService.updateEmployeesLastLogin(employeesLastLoginId, updatedEmployeesLastLoginDto);
		      if (updatedEmployeesLastLogins != null) {
		          logger.info("Updated EmployeeLastLogin with ID: {}", employeesLastLoginId);
		          return new ResponseEntity<>(updatedEmployeesLastLogins, HttpStatus.OK);
		      } else {
		          logger.warn("EmployeeLastLogin with ID {} not found for update", updatedEmployeesLastLogins);
		          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		      }
		  }
		  
		  // Delete EmployeeLastLogin by ID
		  @DeleteMapping("/delete/{employeesLastLoginId}")
		  public ResponseEntity<Void> deleteEmployeeLastLogins(@PathVariable Long employeesLastLoginId) {
			   employeesLastLoginService.deleteEmployeesLastLogin(employeesLastLoginId);
		      logger.info("Deleted EmployeeLastLogin with ID: {}", employeesLastLoginId);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
			    
			    @GetMapping("/count/employees_last_login")
			    public long countEmployeesLastLogins()
			    {
			    	return employeesLastLoginService.countEmployeesLastLogin();
			    }


}
