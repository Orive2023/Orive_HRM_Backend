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

import com.orive.Procurement.Dto.PurchaseOrderDto;
import com.orive.Procurement.Service.PurchaseOrderService;



@RestController
@RequestMapping(value = " purchaseOrder")
@CrossOrigin(origins = "*")
public class PurchaseOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

    @Autowired
    private  PurchaseOrderService purchaseOrderService;
    
    
 // Create a new PurchaseOrder
    @PostMapping("/create/purchaseOrder")
    public ResponseEntity<PurchaseOrderDto> createPurchaseOrder(@RequestBody PurchaseOrderDto purchaseOrderDto) {
    	PurchaseOrderDto createdPurchaseOrder= purchaseOrderService.createPurchaseOrder(purchaseOrderDto);
        logger.info("Created PurchaseOrder with name: {}", createdPurchaseOrder.getLocation());
        return new ResponseEntity<>(createdPurchaseOrder, HttpStatus.CREATED);
    }

    // Get all PurchaseOrder    
    @GetMapping("/get/purchaseOrder")
    public ResponseEntity<List<PurchaseOrderDto>> getAllPurchaseOrder() {
        List<PurchaseOrderDto> purchaseOrder = purchaseOrderService.getAllPurchaseOrder();
        logger.info("Retrieved {} PurchaseOrder from the database", purchaseOrder.size());
        return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
    }

    // Get PurchaseOrderbyId
    @GetMapping("/get/{bidAnalysisId}")
    public ResponseEntity<PurchaseOrderDto> getPurchaseOrderbyId(@PathVariable Long purchaseOrderId) {
        Optional<PurchaseOrderDto> purchaseOrder = purchaseOrderService.getPurchaseOrderById(purchaseOrderId);
        if (purchaseOrder.isPresent()) {
            logger.info("Retrieved PurchaseOrder with ID: {}", purchaseOrderId);
            return new ResponseEntity<>(purchaseOrder.get(), HttpStatus.OK);
        } else {
            logger.warn("PurchaseOrder with ID {} not found", purchaseOrderId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update PurchaseOrder by ID
    @PutMapping("/update/{bidAnalysisId}")
    public ResponseEntity<PurchaseOrderDto> updatePurchaseOrder(@PathVariable Long purchaseOrderId, @RequestBody PurchaseOrderDto updatedPurchaseOrderDto) {
    	PurchaseOrderDto updatedPurchaseOrder= purchaseOrderService.updatePurchaseOrder(purchaseOrderId, updatedPurchaseOrderDto);
        if (updatedPurchaseOrder != null) {
            logger.info("Updated PurchaseOrder with ID: {}", purchaseOrderId);
            return new ResponseEntity<>(updatedPurchaseOrder, HttpStatus.OK);
        } else {
            logger.warn("PurchaseOrder with ID {} not found for update", purchaseOrderId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete PurchaseOrder by ID
    @DeleteMapping("/delete/{bidAnalysisId}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long purchaseOrderId) {
  	  purchaseOrderService.deletePurchaseOrder(purchaseOrderId);
        logger.info("Deleted PurchaseOrder with ID: {}", purchaseOrderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
    //count the total PurchaseOrder
	    @GetMapping("/count/bidAnalysis")
	    public long countPurchaseOrder()
	    {
	    	return purchaseOrderService.countPurchaseOrder();
	    }


}
