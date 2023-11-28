package com.orive.Training.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Training.Dto.TrainingTypeDto;
import com.orive.Training.Entity.TrainingTypeEntity;
import com.orive.Training.Repository.TrainingTypeRepository;

@Service
public class TrainingTypeService {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainingTypeService.class);
	
	@Autowired
	private TrainingTypeRepository trainingTypeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public TrainingTypeDto createTrainingType(TrainingTypeDto trainingTypeDto) {
    	TrainingTypeEntity trainingTypeEntity = convertToEntity(trainingTypeDto);
    	TrainingTypeEntity savedTrainingType = trainingTypeRepository.save(trainingTypeEntity);
        logger.info("Created TrainingType with ID: {}", savedTrainingType.getTrainingTypeId());
        return convertToDTO(savedTrainingType);
    }

    // Read
    public List<TrainingTypeDto> getAllTrainingType() {
        List<TrainingTypeEntity> trainingTypeEntities = trainingTypeRepository.findAll();
        logger.info("Retrieved {} TrainingType from the database", trainingTypeEntities.size());
        return trainingTypeEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by TrainingTypeId
    public Optional<TrainingTypeDto> getTrainingTypeById(Long trainingTypeId) {
        Optional<TrainingTypeEntity> trainingType = trainingTypeRepository.findById(trainingTypeId);
        if (trainingType.isPresent()) {
            return Optional.of(convertToDTO(trainingType.get()));
        } else {
            logger.warn("TrainingType with ID {} not found", trainingTypeId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public TrainingTypeDto updateTrainingType(Long trainingTypeId, TrainingTypeDto trainingTypeDto) {
        Optional<TrainingTypeEntity> existingTrainingTypeOptional = trainingTypeRepository.findById(trainingTypeId);
        if (existingTrainingTypeOptional.isPresent()) {
        	TrainingTypeEntity existingTrainingType = existingTrainingTypeOptional.get();
            existingTrainingType.setOnlineCourse(trainingTypeDto.getOnlineCourse());
        	existingTrainingType.setCustomerServiceTraining(trainingTypeDto.getCustomerServiceTraining());
        	existingTrainingType.setOnTheJobTraining(trainingTypeDto.getOnTheJobTraining());
        	existingTrainingType.setLeadershipDevelopment(trainingTypeDto.getLeadershipDevelopment());
        	modelMapper.map(trainingTypeDto, existingTrainingTypeOptional);
            TrainingTypeEntity updatedTrainingType = trainingTypeRepository.save(existingTrainingType);
            logger.info("Updated TrainingType with ID: {}", updatedTrainingType.getTrainingTypeId());
            return convertToDTO(updatedTrainingType);
        } else {
            logger.warn("TrainingType with ID {} not found for update", trainingTypeId);
            return null;
        }
    }
    
    // Delete
    public void deleteTrainingType(Long trainingTypeId) {
    	trainingTypeRepository.deleteById(trainingTypeId);
        logger.info("Deleted TrainingType with ID: {}", trainingTypeId);
    }

    //count the total TrainingType
    public long countTrainingType()
	 {
		 return trainingTypeRepository.count();
	 }
    
	// Helper method to convert TrainingTypeDTo to TrainingTypeEntity
    private TrainingTypeEntity convertToEntity(TrainingTypeDto trainingTypeDto)
    {
    	return modelMapper.map(trainingTypeDto, TrainingTypeEntity.class);
    }

    // Helper method to convert TrainingTypeEntity  to TrainingTypeDTo
    private TrainingTypeDto convertToDTO(TrainingTypeEntity trainingTypeEntity) {
        return modelMapper.map(trainingTypeEntity, TrainingTypeDto.class);
    } 

}
