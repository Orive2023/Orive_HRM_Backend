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

import com.orive.Employee.Dto.SetRolesDto;
import com.orive.Employee.Service.SetRolesService;



@RestController
@RequestMapping(value = "setroles")
public class SetRolesController {

	private static final Logger logger = LoggerFactory.getLogger(SetRolesController.class);

    @Autowired
    private SetRolesService setRolesService;

  
  	// Create a new Company
      @PostMapping("/create/setRoles")
      public ResponseEntity<SetRolesDto> createRoles(@RequestBody SetRolesDto companyDto) {
    	  SetRolesDto createdCompany = setRolesService.createRoles(companyDto);
          logger.info("Created company with name: {}", createdCompany.getRoleName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/setRoles")
      public ResponseEntity<List<SetRolesDto>> getAllRoles() {
          List<SetRolesDto> companies = setRolesService.getAllRoles();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{rolesId}")
      public ResponseEntity<SetRolesDto> getRolesById(@PathVariable Long rolesId) {
          Optional<SetRolesDto> company = setRolesService.getRolesById(rolesId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", rolesId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", rolesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{rolesId}")
      public ResponseEntity<SetRolesDto> updateRoles(@PathVariable Long rolesId, @RequestBody SetRolesDto updatedCompanyDTO) {
    	  SetRolesDto updatedCompany = setRolesService.updateRoles(rolesId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", rolesId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", rolesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{rolesId}")
      public ResponseEntity<Void> deleteRoles(@PathVariable Long rolesId) {
    	  setRolesService.deleteRoles(rolesId);
          logger.info("Deleted company with ID: {}", rolesId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/setRoles")
  	    public long countRoles()
  	    {
  	    	return setRolesService.countRoles();
  	    }
}
