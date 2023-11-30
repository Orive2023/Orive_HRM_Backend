package com.orive.Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.AwardsDto;
import com.orive.Employee.Dto.TerminationsDto;
import com.orive.Employee.Entity.AwardsEntity;
import com.orive.Employee.Entity.TerminationsEntity;
import com.orive.Employee.Repository.TerminationsRepository;

@Service
public class TerminationsService {
	
	private static final Logger logger = LoggerFactory.getLogger(TerminationsService.class);
	
	@Autowired
	private TerminationsRepository terminationsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public TerminationsDto createTerminations(TerminationsDto terminationsDto) {
    	TerminationsEntity terminationsEntity = convertToEntity(terminationsDto);
    	TerminationsEntity savedTermination = terminationsRepository.save(terminationsEntity);
        logger.info("Created Terminations with ID: {}", savedTermination.getTerminationId());
        return convertToDTO(savedTermination);
    }

    // Read
    public List<TerminationsDto> getAllTerminations() {
        List<TerminationsEntity> terminationsEntities = terminationsRepository.findAll();
        logger.info("Retrieved {} Terminations from the database", terminationsEntities.size());
        return terminationsEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by TerminationsId
    public Optional<TerminationsDto> getTerminationsById(Long terminationsId) {
        Optional<TerminationsEntity> termination = terminationsRepository.findById(terminationsId);
        if (termination.isPresent()) {
            return Optional.of(convertToDTO(termination.get()));
        } else {
            logger.warn("Terminations with ID {} not found", terminationsId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public TerminationsDto updateTerminations(Long terminationsId, TerminationsDto terminationsDto) {
        Optional<TerminationsEntity> existingTerminationsOptional = terminationsRepository.findById(terminationsId);
        if (existingTerminationsOptional.isPresent()) {
        	TerminationsEntity existingTerminations = existingTerminationsOptional.get();
        	existingTerminations.setEmployeeName(terminationsDto.getEmployeeName());
        	existingTerminations.setTerminateDate(terminationsDto.getTerminateDate());
        	existingTerminations.setTerminatedBy(terminationsDto.getTerminatedBy());
            modelMapper.map(terminationsDto, existingTerminations);
            TerminationsEntity updatedTerminations = terminationsRepository.save(existingTerminations);
            logger.info("Updated Terminations with ID: {}", updatedTerminations.getTerminationId());
            return convertToDTO(updatedTerminations);
        } else {
            logger.warn("Terminations with ID {} not found for update", terminationsId);
            return null;
        }
    }
    
    // Delete
    public void deleteTerminations(Long terminationsId) {
    	terminationsRepository.deleteById(terminationsId);
        logger.info("Deleted Terminations with ID: {}", terminationsId);
    }

    //count the total Terminations
    public long countTerminations()
	 {
		 return terminationsRepository.count();
	 }
    
	// Helper method to convert TerminationsDTo to TerminationsEntity
    private TerminationsEntity convertToEntity(TerminationsDto terminationsDto)
    {
    	return modelMapper.map(terminationsDto, TerminationsEntity.class);
    }

    // Helper method to convert TerminationsEntity entity to TerminationsDTo
    private TerminationsDto convertToDTO(TerminationsEntity terminationsEntity) 
    {
        return modelMapper.map(terminationsEntity, TerminationsDto.class);
    } 

}
