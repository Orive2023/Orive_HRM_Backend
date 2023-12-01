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
	    public EmployeesDto createEmployees(EmployeesDto employeesDto) {
	    	EmployeesEntity EmployeesEntity = convertToEntity(employeesDto);
	    	EmployeesEntity savedEmployees = employeesRepository.save(EmployeesEntity);
	        logger.info("Created Employees with ID: {}", savedEmployees.getEmployeeId());
	        return convertToDTO(savedEmployees);
	    }

	    // Read
	    public List<EmployeesDto> getAllEmployees() {
	        List<EmployeesEntity> employeesEntities = employeesRepository.findAll();
	        logger.info("Retrieved {} Employees from the database", employeesEntities.size());
	        return employeesEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by EmployeesId
	    public Optional<EmployeesDto> getEmployeesById(Long employeeId) {
	        Optional<EmployeesEntity> employee = employeesRepository.findById(employeeId);
	        if (employee.isPresent()) {
	            return Optional.of(convertToDTO(employee.get()));
	        } else {
	            logger.warn("Employees with ID {} not found", employeeId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public EmployeesDto updateEmployees(Long employeeId, EmployeesDto employeesDto) {
	        Optional<EmployeesEntity> existingEmployeesOptional = employeesRepository.findById(employeeId);
	        if (existingEmployeesOptional.isPresent()) {
	        	EmployeesEntity existingEmployees = existingEmployeesOptional.get();
	        	existingEmployees.setEmployeeName(employeesDto.getEmployeeName());
	        	existingEmployees.setPhone(employeesDto.getPhone());
	        	existingEmployees.setAccountNumber(employeesDto.getAccountNumber());
	        	existingEmployees.setBasicSalary(employeesDto.getBasicSalary());
	        	existingEmployees.setTransportAllowance(employeesDto.getTransportAllowance());
	        	existingEmployees.setHraAllowances(employeesDto.getHraAllowances());
	        	existingEmployees.setOtherAllowances(employeesDto.getOtherAllowances());
	        	existingEmployees.setPfAllowances(employeesDto.getPfAllowances());
	        	existingEmployees.setDaAllowances(employeesDto.getDaAllowances());
	        	existingEmployees.setMedicalAllowances(employeesDto.getMedicalAllowances());
	        	existingEmployees.setOtherInsurance(employeesDto.getOtherInsurance());
	        	existingEmployees.setTax(employeesDto.getTax());
	            modelMapper.map(employeesDto, existingEmployeesOptional);
	            EmployeesEntity updatedEmployees = employeesRepository.save(existingEmployees);
	            logger.info("Updated Employees with ID: {}", updatedEmployees.getEmployeeId());
	            return convertToDTO(updatedEmployees);
	        } else {
	            logger.warn("Employees with ID {} not found for update", employeeId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteEmployees(Long employeeId) {
	    	employeesRepository.deleteById(employeeId);
	        logger.info("Deleted Employees with ID: {}", employeeId);
	    }

	    //count the total Employees
	    public long countEmployees()
		 {
			 return employeesRepository.count();
		 }
	    
		// Helper method to convert EmployeesDTo to EmployeesEntity
	    private EmployeesEntity convertToEntity(EmployeesDto employeesDto)
	    {
	    	return modelMapper.map(employeesDto, EmployeesEntity.class);
	    }

	    // Helper method to convert EmployeesEntity to EmployeesDTo
	    private EmployeesDto convertToDTO(EmployeesEntity employeesEntity) {
	        return modelMapper.map(employeesEntity, EmployeesDto.class);
	    } 
}
