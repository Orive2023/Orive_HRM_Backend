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
import com.orive.Employee.Dto.ResignationsDto;
import com.orive.Employee.Entity.AwardsEntity;
import com.orive.Employee.Entity.ResignationsEntity;
import com.orive.Employee.Repository.ResignationsRepository;

@Service
public class ResignationsService {
	
	private static final Logger logger=LoggerFactory.getLogger(ResignationsService.class);
	
	@Autowired
	private ResignationsRepository resignationsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public ResignationsDto createResignations(ResignationsDto resignationsDto) {
    	ResignationsEntity resignationsEntity = convertToEntity(resignationsDto);
    	ResignationsEntity savedResignations = resignationsRepository.save(resignationsEntity);
        logger.info("Created Resignation with ID: {}", savedResignations.getResignationId());
        return convertToDTO(savedResignations);
    }

    // Read
    public List<ResignationsDto> getAllResignations() {
        List<ResignationsEntity> resignationsEntities = resignationsRepository.findAll();
        logger.info("Retrieved {} Resignation from the database", resignationsEntities.size());
        return resignationsEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by ResignationsId
    public Optional<ResignationsDto> getResignationsById(Long resignationId) {
        Optional<ResignationsEntity> resignation = resignationsRepository.findById(resignationId);
        if (resignation.isPresent()) {
            return Optional.of(convertToDTO(resignation.get()));
        } else {
            logger.warn("Resignation with ID {} not found", resignationId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public ResignationsDto updateResignations(Long resignationId, ResignationsDto resignationsDto) {
        Optional<ResignationsEntity> existingResignationOptional = resignationsRepository.findById(resignationId);
        if (existingResignationOptional.isPresent()) {
        	ResignationsEntity existingResignation = existingResignationOptional.get();
        	existingResignation.setEmployeeName(resignationsDto.getEmployeeName());
        	existingResignation.setNoticeDate(resignationsDto.getNoticeDate());
        	existingResignation.setResignationDate(resignationsDto.getResignationDate());
            modelMapper.map(resignationsDto, existingResignationOptional);
            ResignationsEntity updatedResignation = resignationsRepository.save(existingResignation);
            logger.info("Updated Resignation with ID: {}", updatedResignation.getResignationId());
            return convertToDTO(updatedResignation);
        } else {
            logger.warn("Resignation with ID {} not found for update", resignationId);
            return null;
        }
    }
    
    // Delete
    public void deleteResignations(Long resignationId) {
    	resignationsRepository.deleteById(resignationId);
        logger.info("Deleted Resignation with ID: {}", resignationId);
    }

    //count the total resignation
    public long countResignations()
	 {
		 return resignationsRepository.count();
	 }
    
 // Helper method to convert ResignationDTo to Resignation entity
    private ResignationsEntity convertToEntity(ResignationsDto resignationsDto)
    {
    	return modelMapper.map(resignationsDto, ResignationsEntity.class);
    }

    // Helper method to convert Resignation entity entity to ResignationDTo
    private ResignationsDto convertToDTO(ResignationsEntity resignationsEntity) {
        return modelMapper.map(resignationsEntity, ResignationsDto.class);
    } 

}
