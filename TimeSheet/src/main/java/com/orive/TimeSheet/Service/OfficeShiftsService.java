package com.orive.TimeSheet.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.TimeSheet.Dto.OfficeShiftsDto;
import com.orive.TimeSheet.Entity.OfficeShiftsEntity;
import com.orive.TimeSheet.Repository.OfficeShiftsRepository;



@Service
public class OfficeShiftsService {

	 private static final Logger logger=LoggerFactory.getLogger(OfficeShiftsService.class);
		
		@Autowired
		private OfficeShiftsRepository officeShiftsRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		
		// Create
	    public OfficeShiftsDto createOfficeShifts(OfficeShiftsDto companyDto) {
	    	OfficeShiftsEntity companyEntity = convertToEntity(companyDto);
	    	OfficeShiftsEntity savedCompany = officeShiftsRepository.save(companyEntity);
	        logger.info("Created Company with ID: {}", savedCompany.getOfficeShiftsId());
	        return convertToDTO(savedCompany);
	    }

	    // Read
	    public List<OfficeShiftsDto> getAllOfficeShifts() {
	        List<OfficeShiftsEntity> companyEntities = officeShiftsRepository.findAll();
	        logger.info("Retrieved {} company from the database", companyEntities.size());
	        return companyEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by CompanyId
	    public Optional<OfficeShiftsDto> getOfficeShiftsById(Long OfficeShiftsId) {
	        Optional<OfficeShiftsEntity> company = officeShiftsRepository.findById(OfficeShiftsId);
	        if (company.isPresent()) {
	            return Optional.of(convertToDTO(company.get()));
	        } else {
	            logger.warn("Company with ID {} not found", OfficeShiftsId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public OfficeShiftsDto updateOfficeShifts(Long OfficeShiftsId, OfficeShiftsDto companyDto) {
	        Optional<OfficeShiftsEntity> existingCompanyOptional = officeShiftsRepository.findById(OfficeShiftsId);
	        if (existingCompanyOptional.isPresent()) {
	        	OfficeShiftsEntity existingCompany = existingCompanyOptional.get();
	            modelMapper.map(companyDto, existingCompanyOptional);
	            OfficeShiftsEntity updatedCompany = officeShiftsRepository.save(existingCompany);
	            logger.info("Updated company with ID: {}", updatedCompany.getOfficeShiftsId());
	            return convertToDTO(updatedCompany);
	        } else {
	            logger.warn("Company with ID {} not found for update", OfficeShiftsId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteOfficeShifts(Long OfficeShiftsId) {
	    	officeShiftsRepository.deleteById(OfficeShiftsId);
	        logger.info("Deleted company with ID: {}", OfficeShiftsId);
	    }

	    //count the total company
	    public long countOfficeShifts()
		 {
			 return officeShiftsRepository.count();
		 }
	    
		// Helper method to convert CompanyDTo to Company entity
	    private OfficeShiftsEntity convertToEntity(OfficeShiftsDto companyDto)
	    {
	    	return modelMapper.map(companyDto, OfficeShiftsEntity.class);
	    }

	    // Helper method to convert Company Entity entity to CompanyDTo
	    private OfficeShiftsDto convertToDTO(OfficeShiftsEntity companyEntity) {
	        return modelMapper.map(companyEntity, OfficeShiftsDto.class);
	    } 
}
