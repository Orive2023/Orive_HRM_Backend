package com.orive.Performance.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Performance.Dto.PerformanceIndicatorDto;
import com.orive.Performance.Entity.PerformanceIndicatorEntity;
import com.orive.Performance.Repository.PerformanceIndicatorRepository;

@Service
public class PerformanceIndicatorService {
	
	private static final Logger logger = LoggerFactory.getLogger(PerformanceIndicatorService.class);
	
	
	@Autowired
	private PerformanceIndicatorRepository performanceIndicatorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
		 public PerformanceIndicatorDto createPerformanceIndicator(PerformanceIndicatorDto performanceIndicatorDto) {
			 PerformanceIndicatorEntity performanceIndicatorEntity = convertToEntity(performanceIndicatorDto);
			 PerformanceIndicatorEntity savedPerformanceIndicator = performanceIndicatorRepository.save(performanceIndicatorEntity);
		        logger.info("Created PerformanceIndicator with ID: {}", savedPerformanceIndicator.getPerformancceIndicatorId());
		        return convertToDTO(savedPerformanceIndicator);
		    }

	    // Read
	    public List<PerformanceIndicatorDto> getAllPerformanceIndicator() {
	        List<PerformanceIndicatorEntity> performanceIndicatorEntities = performanceIndicatorRepository.findAll();
	        logger.info("Retrieved {} PerformanceIndicator from the database", performanceIndicatorEntities.size());
	        return performanceIndicatorEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by PerformanceIndicatorId
	    public Optional<PerformanceIndicatorDto> getPerformanceIndicatorById(Long performanceIndicatorId) {
	        Optional<PerformanceIndicatorEntity> performanceIndicator = performanceIndicatorRepository.findById(performanceIndicatorId);
	        if (performanceIndicator.isPresent()) {
	            return Optional.of(convertToDTO(performanceIndicator.get()));
	        } else {
	            logger.warn("PerformanceIndicator with ID {} not found", performanceIndicatorId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public PerformanceIndicatorDto updatePerformanceIndicator(Long performanceIndicatorId, PerformanceIndicatorDto performanceIndicatorDto) {
	        Optional<PerformanceIndicatorEntity> existingPerformanceIndicatorOptional = performanceIndicatorRepository.findById(performanceIndicatorId);
	        if (existingPerformanceIndicatorOptional.isPresent()) {
	        	PerformanceIndicatorEntity existingPerformanceIndicator = existingPerformanceIndicatorOptional.get();
	            modelMapper.map(performanceIndicatorDto, existingPerformanceIndicator);
	            PerformanceIndicatorEntity updatedPerformanceIndicator = performanceIndicatorRepository.save(existingPerformanceIndicator);
	            logger.info("Updated PerformanceIndicator with ID: {}", updatedPerformanceIndicator.getPerformancceIndicatorId());
	            return convertToDTO(updatedPerformanceIndicator);
	        } else {
	            logger.warn("PerformanceIndicator with ID {} not found for update", performanceIndicatorId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deletePerformanceIndicator(Long performanceIndicatorId) {
	    performanceIndicatorRepository.deleteById(performanceIndicatorId);
	        logger.info("Deleted PerformanceIndicator with ID: {}", performanceIndicatorId);
	    }

	    //count the total PerformanceIndicator
	    public long countPerformanceIndicator()
		 {
			 return performanceIndicatorRepository.count();
		 }
	    
		// Helper method to convert PerformanceIndicatorDTo to PerformanceIndicatorEntity
	    private PerformanceIndicatorEntity convertToEntity(PerformanceIndicatorDto performanceIndicatorDto)
	    {
	    	return modelMapper.map(performanceIndicatorDto, PerformanceIndicatorEntity.class);
	    }

	    // Helper method to convert PerformanceIndicatorEntity entity to PerformanceIndicatorDTo
	    private PerformanceIndicatorDto convertToDTO(PerformanceIndicatorEntity performanceIndicatorEntity) 
	    {
	        return modelMapper.map(performanceIndicatorEntity, PerformanceIndicatorDto.class);
	    } 

	

}
