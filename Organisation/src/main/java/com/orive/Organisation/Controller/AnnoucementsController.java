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

import com.orive.Organisation.Dto.AnnoucementsDto;
import com.orive.Organisation.Service.AnnoucementService;


@RestController
@RequestMapping(value = "announcements")
public class AnnoucementsController {

	private static final Logger logger = LoggerFactory.getLogger(AnnoucementsController.class);

    @Autowired
    private AnnoucementService annoucementService;

  
  	// Create a new Company
      @PostMapping("/create/announcements")
      public ResponseEntity<AnnoucementsDto> createAnnoucement(@RequestBody AnnoucementsDto companyDto) {
    	  AnnoucementsDto createdCompany = annoucementService.createAnnouncements(companyDto);
          logger.info("Created company with name: {}", createdCompany.getCompanyName());
          return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
      }

      // Get all companies
      
      @GetMapping("/get/announcements")
      public ResponseEntity<List<AnnoucementsDto>> getAllAnnoucement() {
          List<AnnoucementsDto> companies = annoucementService.getAllAnnouncements();
          logger.info("Retrieved {} companies from the database", companies.size());
          return new ResponseEntity<>(companies, HttpStatus.OK);
      }

      // Get company by ID
      @GetMapping("/get/{announcementsId}")
      public ResponseEntity<AnnoucementsDto> getAnnoucementById(@PathVariable Long announcementsId) {
          Optional<AnnoucementsDto> company = annoucementService.getAnnouncementsById(announcementsId);
          if (company.isPresent()) {
              logger.info("Retrieved compay with ID: {}", announcementsId);
              return new ResponseEntity<>(company.get(), HttpStatus.OK);
          } else {
              logger.warn("company with ID {} not found", announcementsId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      // Update company by ID
      @PutMapping("/update/{announcementsId}")
      public ResponseEntity<AnnoucementsDto> updateAnnoucement(@PathVariable Long announcementsId, @RequestBody AnnoucementsDto updatedCompanyDTO) {
    	  AnnoucementsDto updatedCompany = annoucementService.updateAnnouncements(announcementsId, updatedCompanyDTO);
          if (updatedCompany != null) {
              logger.info("Updated company with ID: {}", announcementsId);
              return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
          } else {
              logger.warn("Company with ID {} not found for update", announcementsId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Company by ID
      @DeleteMapping("/delete/{announcementsId}")
      public ResponseEntity<Void> deleteAnnoucement(@PathVariable Long announcementsId) {
    	  annoucementService.deleteAnnouncements(announcementsId);
          logger.info("Deleted company with ID: {}", announcementsId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  	    
  	    @GetMapping("/count/announcements")
  	    public long countAnnoucement()
  	    {
  	    	return annoucementService.countAnnouncements();
  	    }
}
