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

import com.orive.Organisation.Dto.DepartmentDto;
import com.orive.Organisation.Service.DepartmentService;



@RestController
@RequestMapping(value = "department")
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

  
  	// Create a new Company
      @PostMapping("/create/department")
      public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto companyDto) {
    	  DepartmentDto createdCompany = departmentService.createDepartment(companyDto);
          logger.info("Created company with name: {}", createdCompany.getCompanyName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/department")
      public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
          List<DepartmentDto> companies = departmentService.getAllDepartment();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{departmentId}")
      public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long departmentId) {
          Optional<DepartmentDto> company = departmentService.getDepartmentById(departmentId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", departmentId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", departmentId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{departmentId}")
      public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long departmentId, @RequestBody DepartmentDto updatedCompanyDTO) {
    	  DepartmentDto updatedCompany = departmentService.updateDepartment(departmentId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", departmentId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", departmentId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{departmentId}")
      public ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId) {
    	  departmentService.deleteDepartment(departmentId);
          logger.info("Deleted company with ID: {}", departmentId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/department")
  	    public long countDepartment()
  	    {
  	    	return departmentService.countDepartment();
  	    }
}
