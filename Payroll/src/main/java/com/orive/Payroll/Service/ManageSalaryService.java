package com.orive.Payroll.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Payroll.Dto.ManageSalaryDto;
import com.orive.Payroll.Entity.ManageSalaryEntity;
import com.orive.Payroll.Repository.ManageSalaryRepository;

@Service
public class ManageSalaryService {
	
	private static final Logger logger = LoggerFactory.getLogger(ManageSalaryService.class);
	
	@Autowired
	private ManageSalaryRepository manageSalaryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public ManageSalaryDto createManageSalary(ManageSalaryDto manageSalaryDto) {
    	ManageSalaryEntity  manageSalaryEntity = convertToEntity(manageSalaryDto);
    	ManageSalaryEntity savedManageSalary = manageSalaryRepository.save(manageSalaryEntity);
        logger.info("Created ManageSalary with ID: {}", savedManageSalary.getManageSalaryId());
        return convertToDTO(savedManageSalary);
    }

    // Read
    public List<ManageSalaryDto> getAllManageSalary() {
        List<ManageSalaryEntity> manageSalaryEntities = manageSalaryRepository.findAll();
        logger.info("Retrieved {} ManageSalary from the database", manageSalaryEntities.size());
        return manageSalaryEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by ManageSalaryId
    public Optional<ManageSalaryDto> getManageSalaryById(Long manageSalaryId) {
        Optional<ManageSalaryEntity> manageSalary = manageSalaryRepository.findById(manageSalaryId);
        if (manageSalary.isPresent()) {
            return Optional.of(convertToDTO(manageSalary.get()));
        } else {
            logger.warn("ManageSalary with ID {} not found", manageSalary);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public ManageSalaryDto updateManageSalary(Long manageSalaryId, ManageSalaryDto manageSalaryDto) {
        Optional<ManageSalaryEntity> existingManageSalaryOptional = manageSalaryRepository.findById(manageSalaryId);
        if (existingManageSalaryOptional.isPresent()) {
        	ManageSalaryEntity existingManageSalary= existingManageSalaryOptional.get();
            modelMapper.map(manageSalaryId, existingManageSalaryOptional);
            ManageSalaryEntity updatedManageSalary = manageSalaryRepository.save(existingManageSalary);
            logger.info("Updated ManageSalary with ID: {}", updatedManageSalary.getManageSalaryId());
            return convertToDTO(updatedManageSalary);
        } else {
            logger.warn("ManageSalary with ID {} not found for update", manageSalaryId);
            return null;
        }
    }
    
    // Delete
    public void deleteManageSalary(Long manageSalaryId) {
    	manageSalaryRepository.deleteById(manageSalaryId);
        logger.info("Deleted ManageSalary with ID: {}", manageSalaryId);
    }

    //count the total ManageSalary
    public long countManageSalary()
	 {
		 return manageSalaryRepository.count();
	 }
    
	// Helper method to convert ManageSalaryDTo to ManageSalaryEntity
    private ManageSalaryEntity convertToEntity(ManageSalaryDto manageSalaryDto)
    {
    	return modelMapper.map(manageSalaryDto, ManageSalaryEntity.class);
    }

 // Helper method to convert ManageSalaryEntity to ManageSalaryDTo
    private ManageSalaryDto convertToDTO(ManageSalaryEntity manageSalaryEntity) {
        return modelMapper.map(manageSalaryEntity, ManageSalaryDto.class);
    } 
}
