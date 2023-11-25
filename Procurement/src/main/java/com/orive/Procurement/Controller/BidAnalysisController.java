package com.orive.Procurement.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Procurement.Dto.BidAnalysisDto;
import com.orive.Procurement.Service.BidAnalysisService;



@RestController
@RequestMapping(value = " bidAnalysis")
@CrossOrigin(origins = "*")
public class BidAnalysisController {
	
	private static final Logger logger = LoggerFactory.getLogger(BidAnalysisController.class);

    @Autowired
    private  BidAnalysisService bidAnalysisService;
    
    
 // Create a new BidAnalysis
    @PostMapping("/create/bidAnalysis")
    public ResponseEntity<BidAnalysisDto> createBidAnalysis(@RequestBody BidAnalysisDto bidAnalysisDto) {
    	BidAnalysisDto createdBidAnalysis= bidAnalysisService.createBidAnalysis(bidAnalysisDto);
        logger.info("Created BidAnalysis with name: {}", createdBidAnalysis.getLocation());
        return new ResponseEntity<>(createdBidAnalysis, HttpStatus.CREATED);
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
	    
	    @GetMapping("/count/bidAnalysis")
	    public long countBidAnalysis()
	    {
	    	return bidAnalysisService.countBidAnalysis();
	    }

}
