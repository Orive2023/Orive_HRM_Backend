package com.orive.Procurement.Controller;

import java.io.IOException;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.orive.Procurement.Dto.CommitteesDto;
import com.orive.Procurement.Entity.GoodReceivedListEntity;
import com.orive.Procurement.Service.CommitteesService;

@RestController
@RequestMapping(value = "committees")
@CrossOrigin(origins = "*")
public class CommitteesController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommitteesController.class);
	
	@Autowired
	private CommitteesService committeesService;
	
	// Create a new Committees
//    @PostMapping("/create/committees")
//    public ResponseEntity<CommitteesDto> createCommittees(@RequestBody CommitteesDto committeesDto) {
//    	CommitteesDto createdCommittees = committeesService.createCommittees(committeesDto);
//        logger.info("Created Committees with name: {}", createdCommittees.getName());
//        return new ResponseEntity<>(createdCommittees, HttpStatus.CREATED);
//    }
	
	
	// Create a new Committees
    @PostMapping("/create/committees")
    public ResponseEntity<?> uploadImage(
            @RequestParam("name")  String name,
            @RequestParam("signature") MultipartFile file) {
                           try {
                          String uploadImage = committeesService.uploadImage(name,file);
                        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
                         } catch (IOException e) {
                            e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
         }
        }
    
    
    
//Get Committees signature by Name
    @GetMapping("/download/{name}")
	public ResponseEntity<?> downloadImage(@PathVariable String name){
		byte[] imageData=committeesService.downloadImage(name);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}   
	
	
	

    // Get all Committees
    @GetMapping("/get/committees")
    public ResponseEntity<List<CommitteesDto>> getAllCommittees() {
        List<CommitteesDto> committees = committeesService.getAllCommittees();
        logger.info("Retrieved {} Committees from the database", committees.size());
        return new ResponseEntity<>(committees, HttpStatus.OK);
    }

    // Get CommitteesbyId
    @GetMapping("/get/{committeesId}")
    public ResponseEntity<CommitteesDto> getCommitteesbyId(@PathVariable Long committeesId) {
        Optional<CommitteesDto> committees = committeesService.getCommitteesById(committeesId);
        if (committees.isPresent()) {
            logger.info("Retrieved Committees with ID: {}", committeesId);
            return new ResponseEntity<>(committees.get(), HttpStatus.OK);
        } else {
            logger.warn("Committees with ID {} not found", committeesId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update Committees by ID
    @PutMapping("/update/{committeesId}")
    public ResponseEntity<CommitteesDto> updateCommittees(@PathVariable Long committeesId, @RequestBody CommitteesDto updatedCommitteesDto) {
    	CommitteesDto updatedCommittees = committeesService.updateCommittees(committeesId, updatedCommitteesDto);
        if (updatedCommittees != null) {
            logger.info("Updated Committees with ID: {}", committeesId);
            return new ResponseEntity<>(updatedCommittees, HttpStatus.OK);
        } else {
            logger.warn("Committees with ID {} not found for update", committeesId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete Committees by ID
    @DeleteMapping("/delete/{committeesId}")
    public ResponseEntity<Void> deleteCommittees(@PathVariable Long committeesId) {
  	  committeesService.deleteCommittees(committeesId);
        logger.info("Deleted Committees with ID: {}", committeesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/committees")
	    public long countCommittees()
	    {
	    	return committeesService.countCommittees();
	    }
}
