package com.orive.Training.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Training.Dto.TrainingListDto;
import com.orive.Training.Entity.TrainingListEntity;
import com.orive.Training.Repository.TrainingListRepository;

@Service
public class TrainingListService {

	private static final Logger logger = LoggerFactory.getLogger(TrainingListService.class);
	
	@Autowired
	private TrainingListRepository trainingListRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public TrainingListDto createTrainingList(TrainingListDto trainingListDto) {
    	TrainingListEntity trainingListEntity = convertToEntity(trainingListDto);
    	TrainingListEntity savedTrainingList = trainingListRepository.save(trainingListEntity);
        logger.info("Created TrainingList with ID: {}", savedTrainingList.getTrainingListId());
        return convertToDTO(savedTrainingList);
    }

    // Read
    public List<TrainingListDto> getAllTrainingList() {
        List<TrainingListEntity> trainingListEntities = trainingListRepository.findAll();
        logger.info("Retrieved {} TrainingList from the database", trainingListEntities.size());
        return trainingListEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by TrainingListId
    public Optional<TrainingListDto> getTrainingListById(Long trainingListId) {
        Optional<TrainingListEntity> trainingList = trainingListRepository.findById(trainingListId);
        if (trainingList.isPresent()) {
            return Optional.of(convertToDTO(trainingList.get()));
        } else {
            logger.warn("TrainingList with ID {} not found", trainingListId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public TrainingListDto updateTrainingList(Long trainingListId, TrainingListDto trainingListDto) {
        Optional<TrainingListEntity> existingTrainingListOptional = trainingListRepository.findById(trainingListId);
        if (existingTrainingListOptional.isPresent()) {
        	TrainingListEntity existingTrainingList = existingTrainingListOptional.get();
            existingTrainingList.setTrainingType(trainingListDto.getTrainingType());
        	existingTrainingList.setTrainingTitle(trainingListDto.getTrainingTitle());
        	existingTrainingList.setTrainingProvider(trainingListDto.getTrainingProvider());
        	existingTrainingList.setTrainingDuration(trainingListDto.getTrainingDuration());
        	existingTrainingList.setTrainingCoordinatorName(trainingListDto.getTrainingCoordinatorName());
        	existingTrainingList.setOverallTrainingRating(trainingListDto.getOverallTrainingRating());
        	modelMapper.map(trainingListDto, existingTrainingListOptional);
            TrainingListEntity updatedTrainingList = trainingListRepository.save(existingTrainingList);
            logger.info("Updated TrainingList with ID: {}", updatedTrainingList.getTrainingListId());
            return convertToDTO(updatedTrainingList);
        } else {
            logger.warn("TrainingList with ID {} not found for update", trainingListId);
            return null;
        }
    }
    
    // Delete
    public void deleteTrainingList(Long trainingListId) {
    	trainingListRepository.deleteById(trainingListId);
        logger.info("Deleted TrainingList with ID: {}", trainingListId);
    }

    //count the total TrainingList
    public long countTrainingList()
	 {
		 return trainingListRepository.count();
	 }
    
	// Helper method to convert TrainingListDTo to TrainingListEntity
    private TrainingListEntity convertToEntity(TrainingListDto trainingListDto)
    {
    	return modelMapper.map(trainingListDto, TrainingListEntity.class);
    }

    // Helper method to convert TrainingListEntity  to TrainingListDTo
    private TrainingListDto convertToDTO(TrainingListEntity trainingListEntity) {
        return modelMapper.map(trainingListEntity, TrainingListDto.class);
    } 	
}
