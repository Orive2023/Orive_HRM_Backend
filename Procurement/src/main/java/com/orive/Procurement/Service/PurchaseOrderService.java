package com.orive.Procurement.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Procurement.Dto.PurchaseOrderDto;
import com.orive.Procurement.Entity.PurchaseOrderEntity;
import com.orive.Procurement.Repository.PurchaseOrderRepository;



@Service
public class PurchaseOrderService {
	
private static final Logger logger= LoggerFactory.getLogger(PurchaseOrderService.class);
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	// Create
		 public PurchaseOrderDto createPurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
			 PurchaseOrderEntity purchaseOrderEntity = convertToEntity(purchaseOrderDto);
			 PurchaseOrderEntity savedPurchaseOrder = purchaseOrderRepository.save(purchaseOrderEntity);
		        logger.info("Created PurchaseOrder with ID: {}", savedPurchaseOrder.getPurchaseOrderId());
		        return convertToDTO(savedPurchaseOrder);
		    }

	    // Read
	    public List<PurchaseOrderDto> getAllPurchaseOrder() {
	        List<PurchaseOrderEntity> purchaseOrderEntities = purchaseOrderRepository.findAll();
	        logger.info("Retrieved {} PurchaseOrder from the database", purchaseOrderEntities.size());
	        return purchaseOrderEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by PurchaseOrderId
	    public Optional<PurchaseOrderDto> getPurchaseOrderById(Long purchaseOrderId) {
	        Optional<PurchaseOrderEntity> purchaseOrder = purchaseOrderRepository.findById(purchaseOrderId);
	        if (purchaseOrder.isPresent()) {
	            return Optional.of(convertToDTO(purchaseOrder.get()));
	        } else {
	            logger.warn("PurchaseOrder with ID {} not found", purchaseOrderId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public PurchaseOrderDto updatePurchaseOrder(Long purchaseOrderId, PurchaseOrderDto purchaseOrderDto) {
	        Optional<PurchaseOrderEntity> existingPurchaseOrderOptional = purchaseOrderRepository.findById(purchaseOrderId);
	        if (existingPurchaseOrderOptional.isPresent()) {
	        	PurchaseOrderEntity existingPurchaseOrder = existingPurchaseOrderOptional.get();
	            existingPurchaseOrder.setVendorName(purchaseOrderDto.getVendorName());
	            existingPurchaseOrder.setLocation(purchaseOrderDto.getLocation());
	        	modelMapper.map(purchaseOrderDto, existingPurchaseOrder);
	            PurchaseOrderEntity updatedPurchaseOrder = purchaseOrderRepository.save(existingPurchaseOrder);
	            logger.info("Updated PurchaseOrder with ID: {}", updatedPurchaseOrder.getPurchaseOrderId());
	            return convertToDTO(updatedPurchaseOrder);
	        } else {
	            logger.warn("PurchaseOrder with ID {} not found for update", purchaseOrderId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deletePurchaseOrder(Long purchaseOrderId) {
	    purchaseOrderRepository.deleteById(purchaseOrderId);
	        logger.info("Deleted PurchaseOrder with ID: {}", purchaseOrderId);
	    }

	    //count the total PurchaseOrder
	    public long countPurchaseOrder()
		 {
			 return purchaseOrderRepository.count();
		 }
	    
		// Helper method to convertPurchaseOrderDTo to PurchaseOrderEntity
	    private PurchaseOrderEntity convertToEntity(PurchaseOrderDto purchaseOrderDto )
	    {
	    	return modelMapper.map(purchaseOrderDto, PurchaseOrderEntity.class);
	    }

	    // Helper method to convert PurchaseOrderEntity  to PurchaseOrderDTo
	    private PurchaseOrderDto convertToDTO(PurchaseOrderEntity purchaseOrderEntity ) 
	    {
	        return modelMapper.map(purchaseOrderEntity, PurchaseOrderDto.class);
	    } 

}
