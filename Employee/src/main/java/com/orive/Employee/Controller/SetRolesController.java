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

import com.orive.Employee.Dto.SetRolesDto;
import com.orive.Employee.Service.SetRolesService;



@RestController
@RequestMapping(value = "setroles")
@CrossOrigin(origins = "*")
public class SetRolesController {

	private static final Logger logger = LoggerFactory.getLogger(SetRolesController.class);

    @Autowired
    private SetRolesService setRolesService;

  
  	// Create a new SetRoles
      @PostMapping("/create/setRoles")
      public ResponseEntity<SetRolesDto> createRoles(@RequestBody SetRolesDto setRolesDto) {
    	  SetRolesDto createdSetRoles = setRolesService.createRoles(setRolesDto);
          logger.info("Created SetRoles with name: {}", createdSetRoles.getRoleName());
          return new ResponseEntity<>(createdSetRoles, HttpStatus.CREATED);
      }

      // Get all SetRoles   
      @GetMapping("/get/setRoles")
      public ResponseEntity<List<SetRolesDto>> getAllRoles() {
          List<SetRolesDto> setRoles = setRolesService.getAllRoles();
          logger.info("Retrieved {} SetRoles from the database", setRoles.size());
          return new ResponseEntity<>(setRoles, HttpStatus.OK);
      }

      // Get SetRoles by ID
      @GetMapping("/get/{rolesId}")
      public ResponseEntity<SetRolesDto> getRolesById(@PathVariable Long rolesId) {
          Optional<SetRolesDto> setRoles = setRolesService.getRolesById(rolesId);
          if (setRoles.isPresent()) {
              logger.info("Retrieved SetRoles with ID: {}", rolesId);
              return new ResponseEntity<>(setRoles.get(), HttpStatus.OK);
          } else {
              logger.warn("SetRoles with ID {} not found", rolesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update SetRoles by ID
      @PutMapping("/update/{rolesId}")
      public ResponseEntity<SetRolesDto> updateRoles(@PathVariable Long rolesId, @RequestBody SetRolesDto updatedSetRolesDto) {
    	  SetRolesDto updatedSetRoles= setRolesService.updateRoles(rolesId, updatedSetRolesDto);
          if (updatedSetRoles != null) {
              logger.info("Updated SetRoles with ID: {}", rolesId);
              return new ResponseEntity<>(updatedSetRoles, HttpStatus.OK);
          } else {
              logger.warn("SetRoles with ID {} not found for update", rolesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete SetRoles by ID
      @DeleteMapping("/delete/{rolesId}")
      public ResponseEntity<Void> deleteRoles(@PathVariable Long rolesId) {
    	  setRolesService.deleteRoles(rolesId);
          logger.info("Deleted SetRoles with ID: {}", rolesId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/setRoles")
  	    public long countRoles()
  	    {
  	    	return setRolesService.countRoles();
  	    }
}
