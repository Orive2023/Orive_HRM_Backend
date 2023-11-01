package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.DepartmentDto;
import com.orive.Organisation.Entity.DepartmentEntity;
import com.orive.Organisation.Repository.DepartmentRepository;



@Service
public class DepartmentService {

    private static final Logger logger=LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
    	DepartmentEntity departmentEntity = convertToEntity(departmentDto);
    	DepartmentEntity savedDepartment = departmentRepository.save(departmentEntity);
        logger.info("Created Department with ID: {}", savedDepartment.getDepartmentId());
        return convertToDTO(savedDepartment);
    }

    // Read
    public List<DepartmentDto> getAllDepartment() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        logger.info("Retrieved {} Department from the database", departmentEntities.size());
        return departmentEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by DepartmentId
    public Optional<DepartmentDto> getDepartmentById(Long departmentId) {
        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            return Optional.of(convertToDTO(department.get()));
        } else {
            logger.warn("Department with ID {} not found", departmentId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {
        Optional<DepartmentEntity> existingDepartmentOptional = departmentRepository.findById(departmentId);
        if (existingDepartmentOptional.isPresent()) {
        	DepartmentEntity existingDepartment = existingDepartmentOptional.get();
            modelMapper.map(departmentDto, existingDepartmentOptional);
            DepartmentEntity updatedDepartment= departmentRepository.save(existingDepartment);
            logger.info("Updated Department with ID: {}", updatedDepartment.getDepartmentId());
            return convertToDTO(updatedDepartment);
        } else {
            logger.warn("Department with ID {} not found for update", departmentId);
            return null;
        }
    }
    
    // Delete
    public void deleteDepartment(Long departmentId) {
    	departmentRepository.deleteById(departmentId);
        logger.info("Deleted Department with ID: {}", departmentId);
    }

    //count the total Department
    public long countDepartment()
	 {
		 return departmentRepository.count();
	 }
    
	// Helper method to convert DepartmentDTo to DepartmentEntity
    private DepartmentEntity convertToEntity(DepartmentDto departmentDto)
    {
    	return modelMapper.map(departmentDto, DepartmentEntity.class);
    }

    // Helper method to convert DepartmentEntity  to DepartmentDTo
    private DepartmentDto convertToDTO(DepartmentEntity departmentEntity) {
        return modelMapper.map(departmentEntity, DepartmentDto.class);
    } 
}
