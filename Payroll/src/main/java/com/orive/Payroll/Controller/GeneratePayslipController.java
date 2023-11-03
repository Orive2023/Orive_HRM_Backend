package com.orive.Payroll.Controller;

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

import com.orive.Payroll.Dto.GeneratePayslipDto;
import com.orive.Payroll.Service.GeneratePayslipService;

@RestController
@RequestMapping(value = "generatepayslip")
public class GeneratePayslipController {
	
	private static final Logger logger =LoggerFactory.getLogger(GeneratePayslipController.class);
	
	@Autowired
	private GeneratePayslipService generatePayslipService;
	
	
	// Create a new GeneratePayslip
    @PostMapping("/create/generatepayslip")
    public ResponseEntity<GeneratePayslipDto> createGeneratePayslip(@RequestBody GeneratePayslipDto generatePayslipDto ) {
    	GeneratePayslipDto createdGeneratePayslip = generatePayslipService.createGeneratePayslip(generatePayslipDto);
        logger.info("Created GeneratePayslip with name: {}", createdGeneratePayslip.getEmployeeFullName());
        return new ResponseEntity<>(createdGeneratePayslip, HttpStatus.CREATED);
    }

    // Get all GeneratePayslip 
    @GetMapping("/get/generatepayslip")
    public ResponseEntity<List<GeneratePayslipDto>> getAllGeneratePayslip() {
        List<GeneratePayslipDto> generatePayslip = generatePayslipService.getAllGeneratePayslip();
        logger.info("Retrieved {} GeneratePayslip from the database", generatePayslip.size());
        return new ResponseEntity<>(generatePayslip, HttpStatus.OK);
    }

    // Get GeneratePayslip by ID
    @GetMapping("/get/{generatePayslipId}")
    public ResponseEntity<GeneratePayslipDto> getGeneratePayslipById(@PathVariable Long generatePayslipId) {
        Optional<GeneratePayslipDto> generatePayslip = generatePayslipService.getGeneratePayslipById(generatePayslipId);
        if (generatePayslip.isPresent()) {
            logger.info("Retrieved GeneratePayslip with ID: {}", generatePayslipId);
            return new ResponseEntity<>(generatePayslip.get(), HttpStatus.OK);
        } else {
            logger.warn("GeneratePayslip with ID {} not found", generatePayslipId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update GeneratePayslip by ID
    @PutMapping("/update/{generatePayslipId}")
    public ResponseEntity<GeneratePayslipDto> updateGeneratePayslip(@PathVariable Long generatePayslipId, @RequestBody GeneratePayslipDto updatedGeneratePayslipDto) {
    	GeneratePayslipDto updatedGeneratePayslip = generatePayslipService.updateGeneratePayslip(generatePayslipId, updatedGeneratePayslipDto);
        if (updatedGeneratePayslip != null) {
            logger.info("Updated GeneratePayslip with ID: {}", generatePayslipId);
            return new ResponseEntity<>(updatedGeneratePayslip, HttpStatus.OK);
        } else {
            logger.warn("GeneratePayslip with ID {} not found for update", generatePayslipId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete GeneratePayslip by ID
    @DeleteMapping("/delete/{generatePayslipId}")
    public ResponseEntity<Void> deleteGeneratePayslip(@PathVariable Long generatePayslipId) {
  	  generatePayslipService.deleteGeneratePayslip(generatePayslipId);
        logger.info("Deleted GeneratePayslip with ID: {}", generatePayslipId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/generatepayslip")
	    public long countGeneratePayslip()
	    {
	    	return generatePayslipService.countGeneratePayslip();
	    }
}
