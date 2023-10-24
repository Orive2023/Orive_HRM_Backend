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

  
  	// Create a new Company
      @PostMapping("/create/payrollTemplate")
      public ResponseEntity<PayrollTemplateDto> createPayRollTemplate(@RequestBody PayrollTemplateDto companyDto) {
    	  PayrollTemplateDto createdCompany = payrollTemplateService.createPayrollTemplate(companyDto);
          logger.info("Created company with name: {}", createdCompany.getTemplateName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/payrollTemplate")
      public ResponseEntity<List<PayrollTemplateDto>> getAllPayRollTemplate() {
          List<PayrollTemplateDto> companies = payrollTemplateService.getAllPayrollTemplate();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{PayRollTemplateId}")
      public ResponseEntity<PayrollTemplateDto> getPayRollTemplateById(@PathVariable Long PayRollTemplateId) {
          Optional<PayrollTemplateDto> company = payrollTemplateService.getPayrollTemplateById(PayRollTemplateId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", PayRollTemplateId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", PayRollTemplateId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{PayRollTemplateId}")
      public ResponseEntity<PayrollTemplateDto> updatePayRollTemplate(@PathVariable Long PayRollTemplateId, @RequestBody PayrollTemplateDto updatedCompanyDTO) {
    	  PayrollTemplateDto updatedCompany = payrollTemplateService.updatePayrollTemplate(PayRollTemplateId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", PayRollTemplateId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", PayRollTemplateId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{PayRollTemplateId}")
      public ResponseEntity<Void> deletePayRollTemplate(@PathVariable Long PayRollTemplateId) {
    	  payrollTemplateService.deletePayrollTemplate(PayRollTemplateId);
          logger.info("Deleted company with ID: {}", PayRollTemplateId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/payrollTemplate")
  	    public long countPayRollTemplate()
  	    {
  	    	return payrollTemplateService.countPayrollTemplate();
  	    }
}
