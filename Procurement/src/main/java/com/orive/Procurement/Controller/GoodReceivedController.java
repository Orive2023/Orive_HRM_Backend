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

import com.orive.Procurement.Dto.GoodReceivedDto;
import com.orive.Procurement.Entity.GoodReceivedListEntity;
import com.orive.Procurement.Service.GoodReceivedService;



@RestController
@RequestMapping(value = "goodreceived")
@CrossOrigin(origins = "*")
public class GoodReceivedController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodReceivedController.class);

    @Autowired
    private GoodReceivedService goodReceivedService;
    
    
 // Create a new GoodReceived
//    @PostMapping("/create/goodreceived")
//    public ResponseEntity<GoodReceivedDto> createGoodReceived(@RequestBody GoodReceivedDto goodReceivedDto) {
//    	GoodReceivedDto createdGoodReceived = goodReceivedService.createGoodReceived(goodReceivedDto);
//        logger.info("Created GoodReceived with name: {}", createdGoodReceived.getPurchaseOrder());
//        return new ResponseEntity<>(createdGoodReceived, HttpStatus.CREATED);
//    }
    
    
  	// Create a new GoodReceived
    @PostMapping("/create/goodreceived")
    public ResponseEntity<?> uploadImage(
            @RequestParam("purchaseOrder")  String purchaseOrder,
            @RequestParam("paymentSource") String paymentSource,
            @RequestParam("vendorName") String vendorName,
            @RequestParam("date")  LocalDate date,
            @RequestParam("receivedByName") String receivedByName,
            @RequestParam("title")  String title,
            @RequestParam("goodReceivedListEntities") List<GoodReceivedListEntity> goodReceivedListEntities,
            @RequestParam("signatureAndStamp") MultipartFile file) {
                           try {
                          String uploadImage = goodReceivedService.uploadImage(purchaseOrder,paymentSource
                          		,vendorName,date,receivedByName,title,goodReceivedListEntities,file);
                        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
                         } catch (IOException e) {
                            e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
         }
        }
    
    
    
//Get GoodReceived signatureAndStamp by VendorName
    @GetMapping("/download/{vendorName}")
	public ResponseEntity<?> downloadImage(@PathVariable String vendorName){
		byte[] imageData=goodReceivedService.downloadImage(vendorName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}   

    // Get all GoodReceived   
    @GetMapping("/get/goodreceived")
    public ResponseEntity<List<GoodReceivedDto>> getAllGoodReceived() {
        List<GoodReceivedDto> goodReceived = goodReceivedService.getAllGoodReceived();
        logger.info("Retrieved {} GoodReceived from the database", goodReceived.size());
        return new ResponseEntity<>(goodReceived, HttpStatus.OK);
    }

    // Get GoodReceivedbyId
    @GetMapping("/get/{goodReceivedId}")
    public ResponseEntity<GoodReceivedDto> getGoodReceivedbyId(@PathVariable Long goodReceivedId) {
        Optional<GoodReceivedDto> goodReceived = goodReceivedService.getGoodReceivedById(goodReceivedId);
        if (goodReceived.isPresent()) {
            logger.info("Retrieved GoodReceived with ID: {}", goodReceivedId);
            return new ResponseEntity<>(goodReceived.get(), HttpStatus.OK);
        } else {
            logger.warn("GoodReceived with ID {} not found", goodReceivedId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update GoodReceived by ID
    @PutMapping("/update/{goodReceivedId}")
    public ResponseEntity<GoodReceivedDto> updateGoodReceived(@PathVariable Long goodReceivedId, @RequestBody GoodReceivedDto updatedGoodReceivedDto) {
    	GoodReceivedDto updatedGoodReceived = goodReceivedService.updateGoodReceived(goodReceivedId, updatedGoodReceivedDto);
        if (updatedGoodReceived != null) {
            logger.info("Updated GoodReceived with ID: {}", goodReceivedId);
            return new ResponseEntity<>(updatedGoodReceived, HttpStatus.OK);
        } else {
            logger.warn("GoodReceived with ID {} not found for update", goodReceivedId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete GoodReceived by ID
    @DeleteMapping("/delete/{goodReceivedId}")
    public ResponseEntity<Void> deleteGoodReceived(@PathVariable Long goodReceivedId) {
  	  goodReceivedService.deleteGoodReceived(goodReceivedId);
        logger.info("Deleted GoodReceived with ID: {}", goodReceivedId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
    //Count the total GoodReceived
	    @GetMapping("/count/goodreceived")
	    public long countGoodReceived()
	    {
	    	return goodReceivedService.countGoodReceived();
	    }


}
