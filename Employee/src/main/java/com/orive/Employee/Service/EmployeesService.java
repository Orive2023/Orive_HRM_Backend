package com.orive.Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.EmployeesDto;
import com.orive.Employee.Entity.EmployeesEntity;
import com.orive.Employee.Repository.EmployeesRepository;

@Service
public class EmployeesService {

	 private static final Logger logger=LoggerFactory.getLogger(EmployeesService.class);
		
		@Autowired
		private EmployeesRepository employeesRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		
		// Create
	    public EmployeesDto createEmployees(EmployeesDto companyDto) {
	    	EmployeesEntity companyEntity = convertToEntity(companyDto);
	    	EmployeesEntity savedCompany = employeesRepository.save(companyEntity);
	        logger.info("Created Company with ID: {}", savedCompany.getEmployeeId());
	        return convertToDTO(savedCompany);
	    }

	    // Read
	    public List<EmployeesDto> getAllEmployees() {
	        List<EmployeesEntity> companyEntities = employeesRepository.findAll();
	        logger.info("Retrieved {} company from the database", companyEntities.size());
	        return companyEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by CompanyId
	    public Optional<EmployeesDto> getEmployeesById(Long employeeId) {
	        Optional<EmployeesEntity> company = employeesRepository.findById(employeeId);
	        if (company.isPresent()) {
	            return Optional.of(convertToDTO(company.get()));
	        } else {
	            logger.warn("Company with ID {} not found", employeeId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public EmployeesDto updateEmployees(Long employeeId, EmployeesDto companyDto) {
	        Optional<EmployeesEntity> existingCompanyOptional = employeesRepository.findById(employeeId);
	        if (existingCompanyOptional.isPresent()) {
	        	EmployeesEntity existingCompany = existingCompanyOptional.get();
	            modelMapper.map(companyDto, existingCompanyOptional);
	            EmployeesEntity updatedCompany = employeesRepository.save(existingCompany);
	            logger.info("Updated company with ID: {}", updatedCompany.getEmployeeId());
	            return convertToDTO(updatedCompany);
	        } else {
	            logger.warn("Company with ID {} not found for update", employeeId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteEmployees(Long employeeId) {
	    	employeesRepository.deleteById(employeeId);
	        logger.info("Deleted company with ID: {}", employeeId);
	    }

	    //count the total company
	    public long countEmployees()
		 {
			 return employeesRepository.count();
		 }
	    
		// Helper method to convert CompanyDTo to Company entity
	    private EmployeesEntity convertToEntity(EmployeesDto companyDto)
	    {
	    	return modelMapper.map(companyDto, EmployeesEntity.class);
	    }

	    // Helper method to convert Company Entity entity to CompanyDTo
	    private EmployeesDto convertToDTO(EmployeesEntity companyEntity) {
	        return modelMapper.map(companyEntity, EmployeesDto.class);
	    } 
}
