package com.orive.Procurement.Controller;

import java.time.LocalDate;
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

import com.orive.Procurement.Dto.BidAnalysisDto;
import com.orive.Procurement.Entity.CommitteeListEntity;
import com.orive.Procurement.Entity.CompanyListEntity;
import com.orive.Procurement.Service.BidAnalysisService;



@RestController
@RequestMapping(value = "bidAnalysis")
@CrossOrigin(origins = "*")
public class BidAnalysisController {
	
	private static final Logger logger = LoggerFactory.getLogger(BidAnalysisController.class);

    @Autowired
    private  BidAnalysisService bidAnalysisService;
    
    
 // Create a new BidAnalysis
//    @PostMapping("/create/bidAnalysis")
//    public ResponseEntity<BidAnalysisDto> createBidAnalysis(@RequestBody BidAnalysisDto bidAnalysisDto) {
//    	BidAnalysisDto createdBidAnalysis= bidAnalysisService.createBidAnalysis(bidAnalysisDto);
//        logger.info("Created BidAnalysis with name: {}", createdBidAnalysis.getLocation());
//        return new ResponseEntity<>(createdBidAnalysis, HttpStatus.CREATED);
//    }

    
 // Create a new BidAnalysis
    @PostMapping("/create/bidAnalysis")
//  @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<String> saveBidAnalysisEntity(
    		@RequestParam String location,
   		    @RequestParam LocalDate date,
   		    @RequestParam String quotation,
            @RequestParam(value = "attachment", required = false) MultipartFile file){
    	
    	String result = bidAnalysisService.saveBidAnalysisEntity( 
    			location, date, quotation, file );
    
    	if(result != null) {
    		 return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to save BidAnalysis Entity", HttpStatus.INTERNAL_SERVER_ERROR);
       
    	}
    }
    
    
 // Get BidAnalysis pdf by id  
    @GetMapping("/download/{bidAnalysisId}")
    public ResponseEntity<byte[]> downloadsPdf(@PathVariable Long bidAnalysisId) {
        byte[] pdf = bidAnalysisService.downloadPdf(bidAnalysisId);

        if (pdf != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(bidAnalysisId + "_bidAnalysisId.pdf").build());
            return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    		
    // Get all BidAnalysis    
    @GetMapping("/get/bidAnalysis")
    public ResponseEntity<List<BidAnalysisDto>> getAllBidAnalysis() {
        List<BidAnalysisDto> bidAnalysis = bidAnalysisService.getAllBidAnalysis();
        logger.info("Retrieved {} BidAnalysis from the database", bidAnalysis.size());
        return new ResponseEntity<>(bidAnalysis, HttpStatus.OK);
    }

    // Get BidAnalysisbyId
    @GetMapping("/get/{bidAnalysisId}")
    public ResponseEntity<BidAnalysisDto> getBidAnalysisbyId(@PathVariable Long bidAnalysisId) {
        Optional<BidAnalysisDto> bidAnalysis = bidAnalysisService.getBidAnalysisById(bidAnalysisId);
        if (bidAnalysis.isPresent()) {
            logger.info("Retrieved BidAnalysis with ID: {}", bidAnalysisId);
            return new ResponseEntity<>(bidAnalysis.get(), HttpStatus.OK);
        } else {
            logger.warn("BidAnalysis with ID {} not found", bidAnalysisId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update BidAnalysis by ID
    @PutMapping("/update/{bidAnalysisId}")
    public ResponseEntity<BidAnalysisDto> updateBidAnalysis(@PathVariable Long bidAnalysisId, @RequestBody BidAnalysisDto updatedBidAnalysisDto) {
    	BidAnalysisDto updatedBidAnalysis= bidAnalysisService.updateBidAnalysis(bidAnalysisId, updatedBidAnalysisDto);
        if (updatedBidAnalysis != null) {
            logger.info("Updated BidAnalysis with ID: {}", bidAnalysisId);
            return new ResponseEntity<>(updatedBidAnalysis, HttpStatus.OK);
        } else {
            logger.warn("BidAnalysis with ID {} not found for update", bidAnalysisId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete BidAnalysis by ID
    @DeleteMapping("/delete/{bidAnalysisId}")
    public ResponseEntity<Void> deleteBidAnalysis(@PathVariable Long bidAnalysisId) {
  	  bidAnalysisService.deleteBidAnalysis(bidAnalysisId);
        logger.info("Deleted BidAnalysis with ID: {}", bidAnalysisId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
    //Count the total BidAnalysis
	    @GetMapping("/count/bidAnalysis")
	    public long countBidAnalysis()
	    {
	    	return bidAnalysisService.countBidAnalysis();
	    }
}
