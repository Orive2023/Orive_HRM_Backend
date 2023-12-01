package com.orive.Organisation.Controller;

import java.io.IOException;
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
      public ResponseEntity<?> uploadImage(
              @RequestParam("companyName") String companyName,
              @RequestParam("companyType") String companyType,
              @RequestParam("legalOrTradingName") String legalOrTradingName,
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
              @RequestParam("createdDate") String createdDate,
//              @RequestParam("status")  String status,
//              @RequestParam("approvedBy") String approvedBy,
              @RequestParam("uploadLogo") MultipartFile file) {
                             try {
                            String uploadImage = companyService.uploadImage(companyName,companyType
                            		,legalOrTradingName,address,registrationNumber,contactNumber,email,website,city,state,zipCode,country,cin,gst,uan,createdDate,file);
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
      @PatchMapping("/{companyId}")
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
  	    
  	    @GetMapping("/count/company")
//  	  @PreAuthorize("hasRole('client_admin')")
  	    public long countCompany()
  	    {
  	    	return companyService.countCompany();
  	    }

}




	

