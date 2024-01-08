package com.orive.Tickets.Controller;

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

import com.orive.Tickets.Dto.TicketsDto;
import com.orive.Tickets.Entity.TicketsEntity;
import com.orive.Tickets.Service.TicketsService;

@RestController
@RequestMapping(value = "tickets")
@CrossOrigin(origins = "*")
public class TicketsController {
	
	private static final Logger logger = LoggerFactory.getLogger(TicketsController.class);
	
	@Autowired
	private TicketsService ticketsService;
	
	
	// Create a new Tickets
	  @PostMapping("/create/tickets")
	  public ResponseEntity<TicketsDto> createTickets(@RequestBody TicketsDto ticketsDto) {
		  TicketsDto createdTickets = ticketsService.createTickets(ticketsDto);
	      logger.info("Created Tickets with id: {}", createdTickets.getTicketsCode());
	      return new ResponseEntity<>(createdTickets, HttpStatus.CREATED);
	  }

	  
	  // Get all Tickets  
	  @GetMapping("/get/tickets")
	  public ResponseEntity<List<TicketsDto>> getAllTickets() {
	      List<TicketsDto> tickets = ticketsService.getAllTickets();
	      logger.info("Retrieved {} Tickets from the database", tickets.size());
	      return new ResponseEntity<>(tickets, HttpStatus.OK);
	  }

	  // Get Tickets by ID
	  @GetMapping("/get/{ticketsId}")
	  public ResponseEntity<TicketsDto> getTicketsId(@PathVariable Long ticketsId) {
	      Optional<TicketsDto> tickets = ticketsService.getTicketsId(ticketsId);
	      if (tickets.isPresent()) {
	          logger.info("Retrieved Tickets with ID: {}", ticketsId);
	          return new ResponseEntity<>(tickets.get(), HttpStatus.OK);
	      } else {
	          logger.warn("Tickets with ID {} not found", ticketsId);
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	  }

	  
	// Get Employee by ID
	  @GetMapping("/{employeeId}")
	    public ResponseEntity<List<TicketsDto>> getTicketsByEmployeeId(@PathVariable Long employeeId) {
	        List<TicketsDto> tickets = ticketsService.getEmployeeId(employeeId);

	        if (tickets.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(tickets);
	        }
	    }
	  
	  
	  // Update Tickets by ID
	  @PutMapping("/update/{ticketsId}")
	  public ResponseEntity<TicketsDto> updateTickets(@PathVariable Long ticketsId, @RequestBody TicketsDto updatedTicketsDto) {
		  TicketsDto updatedTickets = ticketsService.updateTickets(ticketsId, updatedTicketsDto);
	      if (updatedTickets != null) {
	          logger.info("Updated Tickets with ID: {}", ticketsId);
	          return new ResponseEntity<>(updatedTickets, HttpStatus.OK);
	      } else {
	          logger.warn("Tickets with ID {} not found for update", updatedTickets);
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	  }
	  
	  // Delete Tickets by ID
	  @DeleteMapping("/delete/{ticketsId}")
	  public ResponseEntity<Void> deleteTickets(@PathVariable Long ticketsId) {
		   ticketsService.deleteTickets(ticketsId);
	      logger.info("Deleted Tickets with ID: {}", ticketsId);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
		    
		    @GetMapping("/count/tickets")
		    public long countTickets()
		    {
		    	return ticketsService.countTickets();
		    }


}
