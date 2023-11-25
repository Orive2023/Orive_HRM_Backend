package com.orive.Payroll.Controller;

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

import com.orive.Payroll.Dto.HourlyWagesDto;
import com.orive.Payroll.Service.HourlyWagesService;



@RestController
@RequestMapping(value = "hourlywages")
@CrossOrigin(origins = "*")
public class HourlyWagesController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayrollTemplateController.class);

    @Autowired
    private HourlyWagesService hourlyWagesService;
    
    
 // Create a new HourlyWages
    @PostMapping("/create/hourlywages")
    public ResponseEntity<HourlyWagesDto> createHourlyWages(@RequestBody HourlyWagesDto hourlyWagesDto ) {
    	HourlyWagesDto createdhourlyWages = hourlyWagesService.createHourlyWages(hourlyWagesDto);
        logger.info("Created HourlyWages with name: {}", createdhourlyWages.getHourlyWageTitle());
        return new ResponseEntity<>(createdhourlyWages, HttpStatus.CREATED);
    }

    // Get all HourlyWages
    
    @GetMapping("/get/hourlywages")
    public ResponseEntity<List<HourlyWagesDto>> getAllHourlyWages() {
        List<HourlyWagesDto> hourlyWages = hourlyWagesService.getAllHourlyWages();
        logger.info("Retrieved {} HourlyWages from the database", hourlyWages.size());
        return new ResponseEntity<>(hourlyWages, HttpStatus.OK);
    }

    // Get HourlyWages by ID
    @GetMapping("/get/{hourlyWagesId}")
    public ResponseEntity<HourlyWagesDto> getHourlyWagesById(@PathVariable Long hourlyWagesId) {
        Optional<HourlyWagesDto> hourlyWages = hourlyWagesService.getHourlyWagesById(hourlyWagesId);
        if (hourlyWages.isPresent()) {
            logger.info("Retrieved HourlyWages with ID: {}", hourlyWagesId);
            return new ResponseEntity<>(hourlyWages.get(), HttpStatus.OK);
        } else {
            logger.warn("HourlyWages with ID {} not found", hourlyWagesId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update HourlyWages by ID
    @PutMapping("/update/{hourlyWagesId}")
    public ResponseEntity<HourlyWagesDto> updateHourlyWages(@PathVariable Long hourlyWagesId, @RequestBody HourlyWagesDto updatedHourlyWagesDto) {
    	HourlyWagesDto updatedHourlyWages = hourlyWagesService.updateHourlyWages(hourlyWagesId, updatedHourlyWagesDto);
        if (updatedHourlyWages != null) {
            logger.info("Updated HourlyWages with ID: {}", hourlyWagesId);
            return new ResponseEntity<>(updatedHourlyWages, HttpStatus.OK);
        } else {
            logger.warn("HourlyWages with ID {} not found for update", hourlyWagesId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete HourlyWages by ID
    @DeleteMapping("/delete/{hourlyWagesId}")
    public ResponseEntity<Void> deleteHourlyWages(@PathVariable Long hourlyWagesId) {
  	  hourlyWagesService.deleteHourlyWages(hourlyWagesId);
        logger.info("Deleted HourlyWages with ID: {}", hourlyWagesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/hourlywages")
	    public long countHourlyWages()
	    {
	    	return hourlyWagesService.countHourlyWages();
	    }


}
