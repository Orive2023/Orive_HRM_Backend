package com.orive.TimeSheet.Controller;

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

import com.orive.TimeSheet.Dto.LeaveDto;
import com.orive.TimeSheet.Service.LeavesService;



@RestController
@RequestMapping(value = "leaves")
@CrossOrigin(origins = "*")
public class LeavesController {

	private static final Logger logger = LoggerFactory.getLogger(LeavesController.class);

    @Autowired
    private LeavesService leavesService;

  
  	// Create a new Leaves
      @PostMapping("/create/leaves")
      public ResponseEntity<LeaveDto> createLeaves(@RequestBody LeaveDto leaveDto) {
    	  LeaveDto createdLeaves = leavesService.createLeaves(leaveDto);
          logger.info("Created Leaves with name: {}", createdLeaves.getEmployeeName());
          return new ResponseEntity<>(createdLeaves, HttpStatus.CREATED);
      }

      // Get all Leaves
      
      @GetMapping("/get/leaves")
      public ResponseEntity<List<LeaveDto>> getAllLeaves() {
          List<LeaveDto> leaves = leavesService.getAllLeaves();
          logger.info("Retrieved {} Leaves from the database", leaves.size());
          return new ResponseEntity<>(leaves, HttpStatus.OK);
      }

      // Get Leaves by ID
      @GetMapping("/get/{leaveId}")
      public ResponseEntity<LeaveDto> getLeavesById(@PathVariable Long leaveId) {
          Optional<LeaveDto> leave = leavesService.getLeavesById(leaveId);
          if (leave.isPresent()) {
              logger.info("Retrieved Leaves with ID: {}", leaveId);
              return new ResponseEntity<>(leave.get(), HttpStatus.OK);
          } else {
              logger.warn("Leaves with ID {} not found", leaveId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Leaves by ID
      @PutMapping("/update/{leaveId}")
      public ResponseEntity<LeaveDto> updateLeaves(@PathVariable Long leaveId, @RequestBody LeaveDto updatedLeaveDto) {
    	  LeaveDto updatedLeave = leavesService.updateLeaves(leaveId, updatedLeaveDto);
          if (updatedLeave != null) {
              logger.info("Updated Leaves with ID: {}", leaveId);
              return new ResponseEntity<>(updatedLeave, HttpStatus.OK);
          } else {
              logger.warn("Leaves with ID {} not found for update", leaveId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Leaves by ID
      @DeleteMapping("/delete/{leaveId}")
      public ResponseEntity<Void> deleteLeaves(@PathVariable Long leaveId) {
    	  leavesService.deleteLeaves(leaveId);
          logger.info("Deleted Leaves with ID: {}", leaveId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/leaves")
  	    public long countLeaves()
  	    {
  	    	return leavesService.countLeaves();
  	    }
}
