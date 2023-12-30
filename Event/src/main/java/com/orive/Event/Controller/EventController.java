package com.orive.Event.Controller;

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

import com.orive.Event.Dto.EventDto;
import com.orive.Event.Service.EventService;

@RestController
@RequestMapping(value = "event")
@CrossOrigin(origins = "*")
public class EventController {
	
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;
	
	// Create a new Event
    @PostMapping("/create/event")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
    	EventDto createdEvent = eventService.createEvent(eventDto);
        logger.info("Created Event with name: {}", createdEvent.getTitle());
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    // Get all Event      
    @GetMapping("/get/event")
    public ResponseEntity<List<EventDto>> getAllEvent() {
        List<EventDto> event = eventService.getAllEvent();
        logger.info("Retrieved {} Event from the database", event.size());
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    // Get Event by ID
    @GetMapping("/get/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long eventId) {
        Optional<EventDto> event = eventService.getEventById(eventId);
        if (event.isPresent()) {
            logger.info("Retrieved Event with ID: {}", eventId);
            return new ResponseEntity<>(event.get(), HttpStatus.OK);
        } else {
            logger.warn("Event with ID {} not found", eventId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update Event by ID
    @PutMapping("/update/{eventId}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Long eventId, @RequestBody EventDto updatedEventDto) {
    	EventDto updatedEvent = eventService.updateEvent(eventId, updatedEventDto);
        if (updatedEvent != null) {
            logger.info("Updated Event with ID: {}", eventId);
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            logger.warn("Event with ID {} not found for update", eventId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete Event by ID
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
    	eventService.deleteEvent(eventId);
        logger.info("Deleted Event with ID: {}", eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/event")
	    public long countEvent()
	    {
	    	return eventService.countEvent();
	    }

}
