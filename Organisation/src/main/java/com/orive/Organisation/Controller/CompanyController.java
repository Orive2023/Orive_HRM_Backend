package com.orive.Organisation.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import org.springframework.security.access.prepost.PreAuthorize;
import com.orive.Organisation.Dto.CompanyDto;
import com.orive.Organisation.Dto.LocationDto;
import com.orive.Organisation.Entity.CompanyEntity;
import com.orive.Organisation.Exceptions.ResourceNotFoundException;
import com.orive.Organisation.Service.CompanyService;
@RestController
@RequestMapping(value = "company")
@CrossOrigin(origins = "*")
public class CompanyController {

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

  
 	// Create a new Company
      @PostMapping("/create/company")
//      @PreAuthorize("hasRole('client_admin')")
      public ResponseEntity<?> saveCompanyEntity(
    		  @RequestParam("address") String address,
    		  @RequestParam("cin") String cin,
    		  @RequestParam("city") String city,
              @RequestParam("companyName") String companyName,
              @RequestParam("companyType") String companyType,
              @RequestParam("contactNumber") Long contactNumber,
              @RequestParam("country") String country,
              @RequestParam("createdDate") LocalDate createdDate,
              @RequestParam("email") String email,
              @RequestParam(value = "file", required = false) MultipartFile fileDocument,
              @RequestParam("gst") String gst,
              @RequestParam("legalOrTradingName") String legalOrTradingName,           
              @RequestParam("registrationNumber") String registrationNumber,
              @RequestParam("state") String state,
              @RequestParam("uan") String uan,
              @RequestParam("website") String website,  
              @RequestParam("zipCode") int zipCode                                                            
//              @RequestParam("status")  String status,
//              @RequestParam("approvedBy") String approvedBy
              ) {
    	  String result = companyService.saveCompanyEntity( 
    			  address, cin, city,  companyName, companyType, contactNumber, country, createdDate,  email,  fileDocument,  gst, legalOrTradingName, registrationNumber, state, uan, website, zipCode  );
      
      	if(result != null) {
      		 return new ResponseEntity<>(result, HttpStatus.OK);
          } else {
              return new ResponseEntity<>("Failed to save Company entity", HttpStatus.INTERNAL_SERVER_ERROR);
         
      	}
          }      
    
    
 // Get companies logo by name
    @GetMapping("/{companyName}")
//    @PreAuthorize("hasRole('client_admin')")
	public ResponseEntity<?> downloadImage(@PathVariable String companyName){
		byte[] imageData=companyService.downloadImage(companyName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}
     
    
 // Get all companies  
      @GetMapping("/get/company")
//      @PreAuthorize("hasRole('client_user')")
      public ResponseEntity<List<CompanyDto>> getAllCompany() {
          List<CompanyDto> companies = companyService.getAllCompany();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{companyId}")
      public ResponseEntity<CompanyEntity> getCompanyById(@PathVariable Long companyId) {
          try {
              CompanyEntity company = companyService.getCompanyById(companyId);
              return ResponseEntity.ok(company);
          } catch (ResourceNotFoundException e) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
          } catch (Exception e) {
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
          }
      }
      

   // Update company by ID
      @PutMapping("/update/{companyId}")
      public ResponseEntity<Void> partialUpdateCompany(
              @PathVariable Long companyId,
              @RequestBody CompanyEntity companyEntity) {

          companyService.partialUpdateCompany(companyId, companyEntity);
          return new ResponseEntity<>(HttpStatus.OK);
      }


      // Delete Company by ID
      @DeleteMapping("/delete/{companyId}")
      public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
    	  companyService.deleteCompany(companyId);
          logger.info("Deleted company with ID: {}", companyId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
      //Count the total Company
  	    @GetMapping("/count/company")
//  	  @PreAuthorize("hasRole('client_admin')")
  	    public long countCompany()
  	    {
  	    	return companyService.countCompany();
  	    }

}




	

