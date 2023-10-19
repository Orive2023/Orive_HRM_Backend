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
    public DepartmentDto createDepartment(DepartmentDto companyDto) {
    	DepartmentEntity companyEntity = convertToEntity(companyDto);
    	DepartmentEntity savedCompany = departmentRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getDepartmentId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<DepartmentDto> getAllDepartment() {
        List<DepartmentEntity> companyEntities = departmentRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<DepartmentDto> getDepartmentById(Long departmentId) {
        Optional<DepartmentEntity> company = departmentRepository.findById(departmentId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", departmentId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto companyDto) {
        Optional<DepartmentEntity> existingCompanyOptional = departmentRepository.findById(departmentId);
        if (existingCompanyOptional.isPresent()) {
        	DepartmentEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            DepartmentEntity updatedCompany = departmentRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getDepartmentId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", departmentId);
            return null;
        }
    }
    
    // Delete
    public void deleteDepartment(Long departmentId) {
    	departmentRepository.deleteById(departmentId);
        logger.info("Deleted company with ID: {}", departmentId);
    }

    //count the total company
    public long countDepartment()
	 {
		 return departmentRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private DepartmentEntity convertToEntity(DepartmentDto companyDto)
    {
    	return modelMapper.map(companyDto, DepartmentEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private DepartmentDto convertToDTO(DepartmentEntity companyEntity) {
        return modelMapper.map(companyEntity, DepartmentDto.class);
    } 
}
