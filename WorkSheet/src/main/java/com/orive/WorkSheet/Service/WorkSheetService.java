package com.orive.WorkSheet.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.WorkSheet.Dto.WorkSheetDto;
import com.orive.WorkSheet.Entity.WorkSheetEntity;
import com.orive.WorkSheet.Repository.WorkSheetRepository;

@Service
public class WorkSheetService {
	
	private static final Logger logger=LoggerFactory.getLogger(WorkSheetService.class);
	
	@Autowired
	private WorkSheetRepository workSheetRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public WorkSheetDto createWorkSheet(WorkSheetDto workSheetDto) {
    	WorkSheetEntity  workSheetEntity = convertToEntity(workSheetDto);
    	WorkSheetEntity savedWorkSheet = workSheetRepository.save(workSheetEntity);
        logger.info("Created WorkSheet with ID: {}", savedWorkSheet.getWorkSheetId());
        return convertToDTO(savedWorkSheet);
    }

    // Read
    public List<WorkSheetDto> getAllWorkSheets() {
        List<WorkSheetEntity> workSheetEntities = workSheetRepository.findAll();
        logger.info("Retrieved {} WorkSheet from the database", workSheetEntities.size());
        return workSheetEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by WorkSheetId
    public Optional<WorkSheetDto> getWorkSheetId(Long WorkSheetId) {
        Optional<WorkSheetEntity> workSheet = workSheetRepository.findById(WorkSheetId);
        if (workSheet.isPresent()) {
            return Optional.of(convertToDTO(workSheet.get()));
        } else {
            logger.warn("WorkSheet with ID {} not found", WorkSheetId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public WorkSheetDto updateWorkSheet(Long WorkSheetId, WorkSheetDto workSheetDto) {
        Optional<WorkSheetEntity> existingWorkSheetOptional = workSheetRepository.findById(WorkSheetId);
        if (existingWorkSheetOptional.isPresent()) {
        	WorkSheetEntity existingWorkSheet= existingWorkSheetOptional.get();
        	modelMapper.map(workSheetDto, existingWorkSheetOptional);
            WorkSheetEntity updatedWorkSheet = workSheetRepository.save(existingWorkSheet);
            logger.info("Updated WorkSheet with ID: {}", updatedWorkSheet.getWorkSheetId());
            return convertToDTO(updatedWorkSheet);
        } else {
            logger.warn("WorkSheet with ID {} not found for update", WorkSheetId);
            return null;
        }
    }
    
    // Delete
    public void deleteWorkSheet(Long WorkSheetId) {
    	workSheetRepository.deleteById(WorkSheetId);
        logger.info("Deleted WorkSheet with ID: {}", WorkSheetId);
    }

    //count the total WorkSheet
    public long countWorkSheet()
	 {
		 return workSheetRepository.count();
	 }
    
	// Helper method to convert WorkSheetDTo to WorkSheetEntity
    private WorkSheetEntity convertToEntity(WorkSheetDto workSheetDto)
    {
    	return modelMapper.map(workSheetDto, WorkSheetEntity.class);
    }

 // Helper method to convert WorkSheetEntity entity to WorkSheetDTo
    private WorkSheetDto convertToDTO(WorkSheetEntity workSheetEntity) {
        return modelMapper.map(workSheetEntity, WorkSheetDto.class);
    } 

	
	

}
