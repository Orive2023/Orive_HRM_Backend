package com.orive.Organisation.Controller;

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

import com.orive.Organisation.Dto.CompanyDto;

import com.orive.Organisation.Service.CompanyService;
@RestController
@RequestMapping(value = "company")
public class CompanyController {

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

  
  	// Create a new Company
      @PostMapping("/create/company")
      public ResponseEntity<CompanyDto> createSupplier(@RequestBody CompanyDto supplierDTO) {
    	  CompanyDto createdSupplier = companyService.createCompany(supplierDTO);
          logger.info("Created supplier with name: {}", createdSupplier.getCompanyName());
          return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
      }

      // Get all suppliers
      
      @GetMapping("/get/company")
      public ResponseEntity<List<CompanyDto>> getAllSuppliers() {
          List<CompanyDto> suppliers = companyService.getAllCompany();
          logger.info("Retrieved {} suppliers from the database", suppliers.size());
          return new ResponseEntity<>(suppliers, HttpStatus.OK);
      }

      // Get supplier by ID
      @GetMapping("/get/{companyId}")
      public ResponseEntity<CompanyDto> getSupplierById(@PathVariable Long companyId) {
          Optional<CompanyDto> supplier = companyService.getCompanyById(companyId);
          if (supplier.isPresent()) {
              logger.info("Retrieved supplier with ID: {}", companyId);
              return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
          } else {
              logger.warn("Supplier with ID {} not found", companyId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update supplier by ID
      @PutMapping("/update/{companyId}")
      public ResponseEntity<CompanyDto> updateSupplier(@PathVariable Long companyId, @RequestBody CompanyDto updatedSupplierDTO) {
    	  CompanyDto updatedSupplier = companyService.updateCompany(companyId, updatedSupplierDTO);
          if (updatedSupplier != null) {
              logger.info("Updated supplier with ID: {}", companyId);
              return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
          } else {
              logger.warn("Supplier with ID {} not found for update", companyId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete supplier by ID
      @DeleteMapping("/delete/{companyId}")
      public ResponseEntity<Void> deleteSupplier(@PathVariable Long companyId) {
    	  companyService.deleteCompany(companyId);
          logger.info("Deleted supplier with ID: {}", companyId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/supplier")
  	    public long countSupplier()
  	    {
  	    	return companyService.countCompany();
  	    }

}




	

