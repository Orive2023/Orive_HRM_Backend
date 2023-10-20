package com.orive.Employee.Controller;

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

import com.orive.Employee.Dto.TransfersDto;
import com.orive.Employee.Service.TransfersService;


@RestController
@RequestMapping(value = "transfers")
public class TransfersController {

	private static final Logger logger = LoggerFactory.getLogger(TransfersController.class);

    @Autowired
    private TransfersService transfersService;

  
  	// Create a new Company
      @PostMapping("/create/transfers")
      public ResponseEntity<TransfersDto> createTransfers(@RequestBody TransfersDto companyDto) {
    	  TransfersDto createdCompany = transfersService.createTransfers(companyDto);
          logger.info("Created company with name: {}", createdCompany.getEmployeeName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/transfers")
      public ResponseEntity<List<TransfersDto>> getAllTransfers() {
          List<TransfersDto> companies = transfersService.getAllTransfers();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{transferId}")
      public ResponseEntity<TransfersDto> getTransfersById(@PathVariable Long transferId) {
          Optional<TransfersDto> company = transfersService.getTransfersById(transferId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", transferId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", transferId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{transferId}")
      public ResponseEntity<TransfersDto> updateTransfers(@PathVariable Long transferId, @RequestBody TransfersDto updatedCompanyDTO) {
    	  TransfersDto updatedCompany = transfersService.updateTransfers(transferId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", transferId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", transferId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{transferId}")
      public ResponseEntity<Void> deleteTransfers(@PathVariable Long transferId) {
    	  transfersService.deleteTransfers(transferId);
          logger.info("Deleted company with ID: {}", transferId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/transfers")
  	    public long countTransfers()
  	    {
  	    	return transfersService.countTransfers();
  	    }
}
