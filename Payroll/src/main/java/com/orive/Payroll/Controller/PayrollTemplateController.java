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

import com.orive.Payroll.Dto.PayrollTemplateDto;
import com.orive.Payroll.Service.PayrollTemplateService;



@RestController
@RequestMapping(value = "payrolltemplate")
public class PayrollTemplateController {

	private static final Logger logger = LoggerFactory.getLogger(PayrollTemplateController.class);

    @Autowired
    private PayrollTemplateService payrollTemplateService;

  
  	// Create a new payrollTemplate
      @PostMapping("/create/payrolltemplate")
      public ResponseEntity<PayrollTemplateDto> createPayRollTemplate(@RequestBody PayrollTemplateDto payrollTemplateDto) {
    	  PayrollTemplateDto createdpayrollTemplate = payrollTemplateService.createPayrollTemplate(payrollTemplateDto);
          logger.info("Created PayrollTemplate with name: {}", createdpayrollTemplate.getTemplateName());
          return new ResponseEntity<>(createdpayrollTemplate, HttpStatus.CREATED);
      }

      // Get all PayrollTemplate
      
      @GetMapping("/get/payrolltemplate")
      public ResponseEntity<List<PayrollTemplateDto>> getAllPayRollTemplate() {
          List<PayrollTemplateDto> payrollTemplate = payrollTemplateService.getAllPayrollTemplate();
          logger.info("Retrieved {} PayrollTemplate from the database", payrollTemplate.size());
          return new ResponseEntity<>(payrollTemplate, HttpStatus.OK);
      }

      // Get PayrollTemplate by ID
      @GetMapping("/get/{PayRollTemplateId}")
      public ResponseEntity<PayrollTemplateDto> getPayRollTemplateById(@PathVariable Long PayRollTemplateId) {
          Optional<PayrollTemplateDto> payrollTemplate = payrollTemplateService.getPayrollTemplateById(PayRollTemplateId);
          if (payrollTemplate.isPresent()) {
              logger.info("Retrieved PayrollTemplate with ID: {}", PayRollTemplateId);
              return new ResponseEntity<>(payrollTemplate.get(), HttpStatus.OK);
          } else {
              logger.warn("PayrollTemplate with ID {} not found", PayRollTemplateId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update PayrollTemplate by ID
      @PutMapping("/update/{PayRollTemplateId}")
      public ResponseEntity<PayrollTemplateDto> updatePayRollTemplate(@PathVariable Long PayRollTemplateId, @RequestBody PayrollTemplateDto updatedPayrollTemplateDto) {
    	  PayrollTemplateDto updatedPayrollTemplate = payrollTemplateService.updatePayrollTemplate(PayRollTemplateId, updatedPayrollTemplateDto);
          if (updatedPayrollTemplate != null) {
              logger.info("Updated PayrollTemplate with ID: {}", PayRollTemplateId);
              return new ResponseEntity<>(updatedPayrollTemplate, HttpStatus.OK);
          } else {
              logger.warn("PayrollTemplate with ID {} not found for update", PayRollTemplateId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete PayrollTemplate by ID
      @DeleteMapping("/delete/{PayRollTemplateId}")
      public ResponseEntity<Void> deletePayRollTemplate(@PathVariable Long PayRollTemplateId) {
    	  payrollTemplateService.deletePayrollTemplate(PayRollTemplateId);
          logger.info("Deleted PayrollTemplate with ID: {}", PayRollTemplateId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/payrolltemplate")
  	    public long countPayRollTemplate()
  	    {
  	    	return payrollTemplateService.countPayrollTemplate();
  	    }
}
