package com.orive.Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.EmployeesLastLoginDto;
import com.orive.Employee.Dto.WarningsDto;
import com.orive.Employee.Entity.EmployeesLastLoginEntity;
import com.orive.Employee.Entity.WarningsEntity;
import com.orive.Employee.Repository.EmployeesLastLoginRepository;


@Service
public class EmployeesLastLoginService {
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeesLastLoginService.class);
	
	@Autowired
	private EmployeesLastLoginRepository employeesLastLoginRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public EmployeesLastLoginDto createEmployeesLastLogin(EmployeesLastLoginDto employeesLastLoginDto) {
    	EmployeesLastLoginEntity employeesLastLoginEntity = convertToEntity(employeesLastLoginDto);
    	EmployeesLastLoginEntity savedemployeesLastLoginDto = employeesLastLoginRepository.save(employeesLastLoginEntity);
        logger.info("Created EmployeeLastLogin with ID: {}", savedemployeesLastLoginDto.getEmployeeLastLoginId());
        return convertToDTO(savedemployeesLastLoginDto);
    }

    // Read
    public List<EmployeesLastLoginDto> getAllEmployeeLastLogin() {
        List<EmployeesLastLoginEntity> employeesLastLoginEntities = employeesLastLoginRepository.findAll();
        logger.info("Retrieved {} EmployeeLastLogin from the database", employeesLastLoginEntities.size());
        return employeesLastLoginEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by  EmployeeLastLoginId
    public Optional<EmployeesLastLoginDto> getEmployeesLastLoginById(Long employeesLastLoginId) {
        Optional<EmployeesLastLoginEntity> employeesLastLogin = employeesLastLoginRepository.findById(employeesLastLoginId);
        if (employeesLastLogin.isPresent()) {
            return Optional.of(convertToDTO(employeesLastLogin.get()));
        } else {
            logger.warn("EmployeeLastLogin with ID {} not found", employeesLastLoginId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public EmployeesLastLoginDto updateEmployeesLastLogin(Long employeesLastLoginId, EmployeesLastLoginDto employeesLastLoginDto) {
        Optional<EmployeesLastLoginEntity> existingEmployeesLastLoginOptional = employeesLastLoginRepository.findById(employeesLastLoginId);
        if (existingEmployeesLastLoginOptional.isPresent()) {
        	EmployeesLastLoginEntity existingEmployeesLastLogin = existingEmployeesLastLoginOptional.get();
            modelMapper.map(employeesLastLoginDto, existingEmployeesLastLoginOptional);
            EmployeesLastLoginEntity updatedEmployeesLastLogin = employeesLastLoginRepository.save(existingEmployeesLastLogin);
            logger.info("Updated EmployeeLastLogin with ID: {}", updatedEmployeesLastLogin.getEmployeeLastLoginId());
            return convertToDTO(updatedEmployeesLastLogin);
        } else {
            logger.warn("EmployeeLastLogin with ID {} not found for update", employeesLastLoginId);
            return null;
        }
    }
    
    // Delete
    public void deleteEmployeesLastLogin(Long employeesLastLoginId) {
    	employeesLastLoginRepository.deleteById(employeesLastLoginId);
        logger.info("Deleted EmployeeLastLogin with ID: {}", employeesLastLoginId);
    }

    //count the total EmployeeLastLogin
    public long countEmployeesLastLogin()
	 {
		 return employeesLastLoginRepository.count();
	 }
    
 // Helper method to convert EmployeeLastLoginDTo to EmployeeLastLogin entity
    private EmployeesLastLoginEntity convertToEntity(EmployeesLastLoginDto employeesLastLoginDto)
    {
    	return modelMapper.map(employeesLastLoginDto, EmployeesLastLoginEntity.class);
    }

    // Helper method to convert EmployeeLastLogin entity entity to EmployeeLastLoginDTo
    private EmployeesLastLoginDto convertToDTO(EmployeesLastLoginEntity employeesLastLoginEntity) {
        return modelMapper.map(employeesLastLoginEntity, EmployeesLastLoginDto.class);
    } 
	
	
      

}
