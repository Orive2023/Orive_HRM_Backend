package com.orive.Organisation.Controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.access.prepost.PreAuthorize;
import com.orive.Organisation.Dto.CompanyDto;
import org.springframework.web.multipart.MultipartFile;

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
      public ResponseEntity<?> uploadImage(
              @RequestParam("companyName") String companyName,
              @RequestParam("incomeTaxNumber") String incomeTaxNumber,
              @RequestParam("companyType") String companyType,
              @RequestParam("legalOrTrandingName") String legalOrTrandingName,
              @RequestParam("address") String address,
              @RequestParam("registrationNumber") String registrationNumber,
              @RequestParam("contactNumber") Long contactNumber,
              @RequestParam("email") String email,
              @RequestParam("website") String website,
              @RequestParam("city") String city,
              @RequestParam("state") String state,
              @RequestParam("zipCode") int zipCode,
              @RequestParam("country") String country,
              @RequestParam("cin") String cin,
              @RequestParam("gst") String gst,
              @RequestParam("uan") String uan,
              @RequestParam("status")  String status,
              @RequestParam("approvedBy") String approvedBy,
              @RequestParam("companyLogo") MultipartFile file) {
                             try {
                            String uploadImage = companyService.uploadImage(companyName,incomeTaxNumber,companyType
                            		,legalOrTrandingName,address,registrationNumber,contactNumber,email,website,city,state,zipCode,country,cin,gst,uan ,status,approvedBy,file);
                          return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
                           } catch (IOException e) {
                              e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
           }
          }
      
      
      
// Get companies logo by name
      @GetMapping("/{companyName}")
//      @PreAuthorize("hasRole('client_admin')")
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
      public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long companyId) {
          Optional<CompanyDto> company = companyService.getCompanyById(companyId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", companyId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", companyId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{companyId}")
      public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long companyId, @RequestBody CompanyDto updatedCompanyDTO) {
    	  CompanyDto updatedCompany = companyService.updateCompany(companyId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", companyId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", companyId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{companyId}")
      public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
    	  companyService.deleteCompany(companyId);
          logger.info("Deleted company with ID: {}", companyId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/company")
//  	  @PreAuthorize("hasRole('client_admin')")
  	    public long countCompany()
  	    {
  	    	return companyService.countCompany();
  	    }

}




	

