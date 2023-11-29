package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orive.Organisation.Dto.DesignationDto;
import com.orive.Organisation.Entity.DesignationEntity;
import com.orive.Organisation.Repository.DesignationRepository;

@Service
public class DesignationService {

	private static final Logger logger=LoggerFactory.getLogger(DesignationService.class);
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public DesignationDto createDesignation(DesignationDto designationDto) {
    	DesignationEntity designationEntity = convertToEntity(designationDto);
    	DesignationEntity savedDesignation = designationRepository.save(designationEntity);
        logger.info("Created Designation with ID: {}", savedDesignation.getDesignationId());
        return convertToDTO(savedDesignation);
    }

    // Read
    public List<DesignationDto> getAllDesignation() {
        List<DesignationEntity> designationEntities = designationRepository.findAll();
        logger.info("Retrieved {} Designation from the database", designationEntities.size());
        return designationEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by DesignationId
    public Optional<DesignationDto> getDesignationById(Long designationId) {
        Optional<DesignationEntity> designation = designationRepository.findById(designationId);
        if (designation.isPresent()) {
            return Optional.of(convertToDTO(designation.get()));
        } else {
            logger.warn("Designation with ID {} not found", designationId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public DesignationDto updateDesignation(Long designationId, DesignationDto designationDto) {
        Optional<DesignationEntity> existingDesignationOptional = designationRepository.findById(designationId);
        if (existingDesignationOptional.isPresent()) {
        	DesignationEntity existingDesignation = existingDesignationOptional.get();
        	existingDesignation.setDesignationName(designationDto.getDesignationName());
            modelMapper.map(designationDto, existingDesignationOptional);
            DesignationEntity updatedDesignation = designationRepository.save(existingDesignation);
            logger.info("Updated Designation with ID: {}", updatedDesignation.getDesignationId());
            return convertToDTO(updatedDesignation);
        } else {
            logger.warn("Designation with ID {} not found for update", designationId);
            return null;
        }
    }
    
    // Delete
    public void deleteDesignation(Long designationId) {
    	designationRepository.deleteById(designationId);
        logger.info("Deleted Designation with ID: {}", designationId);
    }

    //count the total Designation
    public long countDesignation()
	 {
		 return designationRepository.count();
	 }
    
	// Helper method to convert DesignationDTo to DesignationEntity
    private DesignationEntity convertToEntity(DesignationDto designationDto)
    {
    	return modelMapper.map(designationDto, DesignationEntity.class);
    }

    // Helper method to convert DesignationEntity  to DesignationDTo
    private DesignationDto convertToDTO(DesignationEntity designationEntity) {
        return modelMapper.map(designationEntity, DesignationDto.class);
    } 
	
}
