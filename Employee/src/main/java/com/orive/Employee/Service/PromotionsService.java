package com.orive.Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.PromotionsDto;
import com.orive.Employee.Dto.TravelsDto;
import com.orive.Employee.Entity.PromotionsEntity;
import com.orive.Employee.Entity.TravelsEntity;
import com.orive.Employee.Repository.PromotionsRepository;

@Service
public class PromotionsService {
	
	private static final Logger logger=LoggerFactory.getLogger(PromotionsService.class);
	
	@Autowired
	private PromotionsRepository promotionsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public PromotionsDto createPromotions(PromotionsDto promotionsDto) {
    	PromotionsEntity promotionsEntity = convertToEntity(promotionsDto);
    	PromotionsEntity savedPromotions = promotionsRepository.save(promotionsEntity);
        logger.info("Created promotions with ID: {}", savedPromotions.getPromotionsId());
        return convertToDTO(savedPromotions);
    }

    // Read
    public List<PromotionsDto> getAllPromotions() {
        List<PromotionsEntity> PromotionsEntities = promotionsRepository.findAll();
        logger.info("Retrieved {} Promotions from the database", PromotionsEntities.size());
        return PromotionsEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by PpromotionsId
    public Optional<PromotionsDto> getPromotionsById(Long promotionsId) {
        Optional<PromotionsEntity> promotions = promotionsRepository.findById(promotionsId);
        if (promotions.isPresent()) {
            return Optional.of(convertToDTO(promotions.get()));
        } else {
            logger.warn("Promotions with ID {} not found", promotionsId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public PromotionsDto updatePromotions(Long promotionsId, PromotionsDto promotionsDto) {
        Optional<PromotionsEntity> existingPromotionsOptional = promotionsRepository.findById(promotionsId);
        if (existingPromotionsOptional.isPresent()) {
        	PromotionsEntity existingPromotions = existingPromotionsOptional.get();
        	existingPromotions.setEmployeeName(promotionsDto.getEmployeeName());
        	existingPromotions.setPromotionTitle(promotionsDto.getPromotionTitle());
        	existingPromotions.setPromotionDate(promotionsDto.getPromotionDate());
            modelMapper.map(promotionsDto, existingPromotionsOptional);
            PromotionsEntity updatedPromotions = promotionsRepository.save(existingPromotions);
            logger.info("Updated Promotions with ID: {}", updatedPromotions.getPromotionsId());
            return convertToDTO(updatedPromotions);
        } else {
            logger.warn("Promotions with ID {} not found for update", promotionsId);
            return null;
        }
    }
    
    // Delete
    public void deletePromotions(Long promotionsId) {
    	promotionsRepository.deleteById(promotionsId);
        logger.info("Deleted Promotions with ID: {}", promotionsId);
    }

    //count the total Promotions
    public long countPromotions()
	 {
		 return promotionsRepository.count();
	 }
    
 // Helper method to convert PromotionsDTo to PromotionsEntity
    private PromotionsEntity convertToEntity(PromotionsDto promotionsDto)
    {
    	return modelMapper.map(promotionsDto, PromotionsEntity.class);
    }

    // Helper method to convert PromotionsEntity to PromotionsDTo
    private PromotionsDto convertToDTO(PromotionsEntity promotionsEntity) {
        return modelMapper.map(promotionsEntity, PromotionsDto.class);
    } 
}
