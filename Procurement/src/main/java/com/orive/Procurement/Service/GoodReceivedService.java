package com.orive.Procurement.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Procurement.Dto.GoodReceivedDto;
import com.orive.Procurement.Entity.GoodReceivedEntity;
import com.orive.Procurement.Repository.GoodReceivedRepository;

@Service
public class GoodReceivedService {
	
private static final Logger logger= LoggerFactory.getLogger(GoodReceivedService.class);
	
	@Autowired
	private GoodReceivedRepository goodReceivedRepository;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	// Create
		 public GoodReceivedDto createGoodReceived(GoodReceivedDto goodReceivedDto) {
			 GoodReceivedEntity goodReceivedEntity = convertToEntity(goodReceivedDto);
			 GoodReceivedEntity savedGoodReceived = goodReceivedRepository.save(goodReceivedEntity);
		        logger.info("Created GoodReceived with ID: {}", savedGoodReceived.getGoodReceivedId());
		        return convertToDTO(savedGoodReceived);
		    }

	    // Read
	    public List<GoodReceivedDto> getAllGoodReceived() {
	        List<GoodReceivedEntity> goodReceivedEntities = goodReceivedRepository.findAll();
	        logger.info("Retrieved {} GoodReceived from the database", goodReceivedEntities.size());
	        return goodReceivedEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by GoodReceivedId
	    public Optional<GoodReceivedDto> getGoodReceivedById(Long goodReceivedId) {
	        Optional<GoodReceivedEntity> goodReceived = goodReceivedRepository.findById(goodReceivedId);
	        if (goodReceived.isPresent()) {
	            return Optional.of(convertToDTO(goodReceived.get()));
	        } else {
	            logger.warn("GoodReceived with ID {} not found", goodReceivedId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public GoodReceivedDto updateGoodReceived(Long goodReceivedId, GoodReceivedDto goodReceivedDto) {
	        Optional<GoodReceivedEntity> existingGoodReceivedOptional = goodReceivedRepository.findById(goodReceivedId);
	        if (existingGoodReceivedOptional.isPresent()) {
	        	GoodReceivedEntity existingGoodReceived = existingGoodReceivedOptional.get();
	            existingGoodReceived.setVendorName(goodReceivedDto.getVendorName());
	            existingGoodReceived.setPaymentSource(goodReceivedDto.getPaymentSource());
	        	modelMapper.map(goodReceivedDto, existingGoodReceivedOptional);
	        	GoodReceivedEntity updatedGoodReceived = goodReceivedRepository.save(existingGoodReceived);
	            logger.info("Updated GoodReceived with ID: {}", updatedGoodReceived.getGoodReceivedId());
	            return convertToDTO(updatedGoodReceived);
	        } else {
	            logger.warn("GoodReceived with ID {} not found for update", goodReceivedId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteGoodReceived(Long goodReceivedId) {
	    	goodReceivedRepository.deleteById(goodReceivedId);
	        logger.info("Deleted GoodReceived with ID: {}", goodReceivedId);
	    }

	    //count the total GoodReceived
	    public long countGoodReceived()
		 {
			 return goodReceivedRepository.count();
		 }
	    
		// Helper method to convert GoodReceivedDTo to GoodReceivedEntity
	    private GoodReceivedEntity convertToEntity(GoodReceivedDto goodReceivedDto )
	    {
	    	return modelMapper.map(goodReceivedDto, GoodReceivedEntity.class);
	    }

	    // Helper method to convert GoodReceivedEntity  to GoodReceivedDTo
	    private GoodReceivedDto convertToDTO(GoodReceivedEntity goodReceivedEntity ) 
	    {
	        return modelMapper.map(goodReceivedEntity, GoodReceivedDto.class);
	    } 

}
