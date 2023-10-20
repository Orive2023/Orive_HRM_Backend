package com.orive.TimeSheet.Controller;

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

import com.orive.TimeSheet.Dto.LeaveDto;
import com.orive.TimeSheet.Service.LeavesService;



@RestController
@RequestMapping(value = "leaves")
public class LeavesController {

	private static final Logger logger = LoggerFactory.getLogger(LeavesController.class);

    @Autowired
    private LeavesService leavesService;

  
  	// Create a new Company
      @PostMapping("/create/leaves")
      public ResponseEntity<LeaveDto> createLeaves(@RequestBody LeaveDto companyDto) {
    	  LeaveDto createdCompany = leavesService.createLeaves(companyDto);
          logger.info("Created company with name: {}", createdCompany.getEmployeeName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/leaves")
      public ResponseEntity<List<LeaveDto>> getAllLeaves() {
          List<LeaveDto> companies = leavesService.getAllLeaves();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{leaveId}")
      public ResponseEntity<LeaveDto> getLeavesById(@PathVariable Long leaveId) {
          Optional<LeaveDto> company = leavesService.getLeavesById(leaveId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", leaveId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", leaveId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{leaveId}")
      public ResponseEntity<LeaveDto> updateLeaves(@PathVariable Long leaveId, @RequestBody LeaveDto updatedCompanyDTO) {
    	  LeaveDto updatedCompany = leavesService.updateLeaves(leaveId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", leaveId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", leaveId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{leaveId}")
      public ResponseEntity<Void> deleteLeaves(@PathVariable Long leaveId) {
    	  leavesService.deleteLeaves(leaveId);
          logger.info("Deleted company with ID: {}", leaveId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/leaves")
  	    public long countLeaves()
  	    {
  	    	return leavesService.countLeaves();
  	    }
}
