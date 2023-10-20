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

  
  	// Create a new Company
      @PostMapping("/create/employees")
      public ResponseEntity<EmployeesDto> createEmployees(@RequestBody EmployeesDto companyDto) {
    	  EmployeesDto createdCompany = employeesService.createEmployees(companyDto);
          logger.info("Created company with name: {}", createdCompany.getEmployeeName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/employees")
      public ResponseEntity<List<EmployeesDto>> getAllEmployees() {
          List<EmployeesDto> companies = employeesService.getAllEmployees();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{employeeId}")
      public ResponseEntity<EmployeesDto> getEmployeesById(@PathVariable Long employeeId) {
          Optional<EmployeesDto> company = employeesService.getEmployeesById(employeeId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", employeeId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", employeeId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{employeeId}")
      public ResponseEntity<EmployeesDto> updateEmployees(@PathVariable Long employeeId, @RequestBody EmployeesDto updatedCompanyDTO) {
    	  EmployeesDto updatedCompany = employeesService.updateEmployees(employeeId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", employeeId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", employeeId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{employeeId}")
      public ResponseEntity<Void> deleteEmployees(@PathVariable Long employeeId) {
    	  employeesService.deleteEmployees(employeeId);
          logger.info("Deleted company with ID: {}", employeeId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/employees")
  	    public long countEmployees()
  	    {
  	    	return employeesService.countEmployees();
  	    }
}
