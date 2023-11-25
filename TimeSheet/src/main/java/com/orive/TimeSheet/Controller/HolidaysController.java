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

import com.orive.TimeSheet.Dto.HolidaysDto;
import com.orive.TimeSheet.Service.HolidaysService;


@RestController
@RequestMapping(value = "holidays")
@CrossOrigin(origins = "*")
public class HolidaysController {

	private static final Logger logger = LoggerFactory.getLogger(HolidaysController.class);

    @Autowired
    private HolidaysService holidaysService;

  
  	// Create a new Holidays
      @PostMapping("/create/holidays")
      public ResponseEntity<HolidaysDto> createHolidays(@RequestBody HolidaysDto holidaysDto) {
    	  HolidaysDto createdHoliday = holidaysService.createHolidays(holidaysDto);
          logger.info("Created Holidays with name: {}", createdHoliday.getEventName());
          return new ResponseEntity<>(createdHoliday, HttpStatus.CREATED);
      }

      // Get all Holidays   
      @GetMapping("/get/holidays")
      public ResponseEntity<List<HolidaysDto>> getAllHolidays() {
          List<HolidaysDto> holidays = holidaysService.getAllHolidays();
          logger.info("Retrieved {} Holidays from the database", holidays.size());
          return new ResponseEntity<>(holidays, HttpStatus.OK);
      }

      // Get Holidays by ID
      @GetMapping("/get/{holidaysId}")
      public ResponseEntity<HolidaysDto> getHolidaysById(@PathVariable Long holidaysId) {
          Optional<HolidaysDto> holidays = holidaysService.getHolidaysById(holidaysId);
          if (holidays.isPresent()) {
              logger.info("Retrieved Holidays with ID: {}", holidaysId);
              return new ResponseEntity<>(holidays.get(), HttpStatus.OK);
          } else {
              logger.warn("Holidays with ID {} not found", holidaysId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Holidays by ID
      @PutMapping("/update/{holidaysId}")
      public ResponseEntity<HolidaysDto> updateHolidays(@PathVariable Long holidaysId, @RequestBody HolidaysDto updatedHolidaysDto) {
    	  HolidaysDto updatedHolidays = holidaysService.updateHolidays(holidaysId, updatedHolidaysDto);
          if (updatedHolidays != null) {
              logger.info("Updated Holidays with ID: {}", holidaysId);
              return new ResponseEntity<>(updatedHolidays, HttpStatus.OK);
          } else {
              logger.warn("Holidays with ID {} not found for update", holidaysId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Holidays by ID
      @DeleteMapping("/delete/{holidaysId}")
      public ResponseEntity<Void> deleteHolidays(@PathVariable Long holidaysId) {
    	  holidaysService.deleteHolidays(holidaysId);
          logger.info("Deleted Holidays with ID: {}", holidaysId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/holidays")
  	    public long countHolidays()
  	    {
  	    	return holidaysService.countHolidays();
  	    }
}
