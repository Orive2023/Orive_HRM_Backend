package com.orive.Organisation.Controller;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.orive.Organisation.Dto.PoliciesDto;
import com.orive.Organisation.Service.PoliciesService;



@RestController
@RequestMapping(value = "policies")
@CrossOrigin(origins = "*")
public class PoliciesController {

	private static final Logger logger = LoggerFactory.getLogger(PoliciesController.class);

    @Autowired
    private PoliciesService policiesService;
    
 // Create a new policies
    @PostMapping("/create/policies")
    public ResponseEntity<String> savePoliciesEntity(
    		 @RequestParam String companyName,
    		 @RequestParam String title,
    		 @RequestParam  String description,
    		 @RequestParam LocalDate createdDate,
    		 @RequestParam(value = "uploadPdf", required = false) MultipartFile file){
    	
    	String result = policiesService.savePoliciesEntity( 
    			companyName, title, description, createdDate, file );
    
    	if(result != null) {
    		 return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to save policies entity", HttpStatus.INTERNAL_SERVER_ERROR);
       
    	}
    }
    
 // Get Policies pdf by id  
    @GetMapping("/download/{policiesId}")
    public ResponseEntity<byte[]> downloadsPdf(@PathVariable Long policiesId) {
        byte[] pdf = policiesService.downloadPdf(policiesId);

        if (pdf != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(policiesId + "_policies.pdf").build());
            return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    		

      // Get all Policies  
      @GetMapping("/get/policies")
      public ResponseEntity<List<PoliciesDto>> getAllPolicies() {
          List<PoliciesDto> policies = policiesService.getAllPolicies();
          logger.info("Retrieved {} Policies from the database", policies.size());
          return new ResponseEntity<>(policies, HttpStatus.OK);
      }

      // Get Policies by ID
      @GetMapping("/get/{policiesId}")
      public ResponseEntity<PoliciesDto> getPoliciesById(@PathVariable Long policiesId) {
          Optional<PoliciesDto> policies = policiesService.getPoliciesById(policiesId);
          if (policies.isPresent()) {
              logger.info("Retrieved Policies with ID: {}", policiesId);
              return new ResponseEntity<>(policies.get(), HttpStatus.OK);
          } else {
              logger.warn("Policies with ID {} not found", policiesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update Policies by ID
      @PutMapping("/update/{policiesId}")
      public ResponseEntity<PoliciesDto> updatePolicies(@PathVariable Long policiesId, @RequestBody PoliciesDto updatedPoliciesDto) {
    	  PoliciesDto updatedPolicies = policiesService.updatePolicies(policiesId, updatedPoliciesDto);
          if (updatedPolicies != null) {
              logger.info("Updated Policies with ID: {}", policiesId);
              return new ResponseEntity<>(updatedPolicies, HttpStatus.OK);
          } else {
              logger.warn("Policies with ID {} not found for update", policiesId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Policies by ID
      @DeleteMapping("/delete/{policiesId}")
      public ResponseEntity<Void> deletePolicies(@PathVariable Long policiesId) {
    	  policiesService.deletePolicies(policiesId);
          logger.info("Deleted Policies with ID: {}", policiesId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
      //Count the total Policies
  	    @GetMapping("/count/policies")
  	    public long countPolicies()
  	    {
  	    	return policiesService.countPolicies();
  	    }
}
