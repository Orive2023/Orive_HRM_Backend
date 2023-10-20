package com.orive.TimeSheet.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.TimeSheet.Dto.HolidaysDto;
import com.orive.TimeSheet.Entity.HolidaysEntity;
import com.orive.TimeSheet.Repository.HolidaysRepository;



@Service
public class HolidaysService {

	 private static final Logger logger=LoggerFactory.getLogger(HolidaysService.class);
		
		@Autowired
		private HolidaysRepository holidaysRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		
		// Create
	    public HolidaysDto createHolidays(HolidaysDto companyDto) {
	    	HolidaysEntity companyEntity = convertToEntity(companyDto);
	    	HolidaysEntity savedCompany = holidaysRepository.save(companyEntity);
	        logger.info("Created Company with ID: {}", savedCompany.getHolidaysId());
	        return convertToDTO(savedCompany);
	    }

	    // Read
	    public List<HolidaysDto> getAllHolidays() {
	        List<HolidaysEntity> companyEntities = holidaysRepository.findAll();
	        logger.info("Retrieved {} company from the database", companyEntities.size());
	        return companyEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by CompanyId
	    public Optional<HolidaysDto> getHolidaysById(Long holidaysId) {
	        Optional<HolidaysEntity> company = holidaysRepository.findById(holidaysId);
	        if (company.isPresent()) {
	            return Optional.of(convertToDTO(company.get()));
	        } else {
	            logger.warn("Company with ID {} not found", holidaysId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public HolidaysDto updateHolidays(Long holidaysId, HolidaysDto companyDto) {
	        Optional<HolidaysEntity> existingCompanyOptional = holidaysRepository.findById(holidaysId);
	        if (existingCompanyOptional.isPresent()) {
	        	HolidaysEntity existingCompany = existingCompanyOptional.get();
	            modelMapper.map(companyDto, existingCompanyOptional);
	            HolidaysEntity updatedCompany = holidaysRepository.save(existingCompany);
	            logger.info("Updated company with ID: {}", updatedCompany.getHolidaysId());
	            return convertToDTO(updatedCompany);
	        } else {
	            logger.warn("Company with ID {} not found for update", holidaysId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteHolidays(Long holidaysId) {
	    	holidaysRepository.deleteById(holidaysId);
	        logger.info("Deleted company with ID: {}", holidaysId);
	    }

	    //count the total company
	    public long countHolidays()
		 {
			 return holidaysRepository.count();
		 }
	    
		// Helper method to convert CompanyDTo to Company entity
	    private HolidaysEntity convertToEntity(HolidaysDto companyDto)
	    {
	    	return modelMapper.map(companyDto, HolidaysEntity.class);
	    }

	    // Helper method to convert Company Entity entity to CompanyDTo
	    private HolidaysDto convertToDTO(HolidaysEntity companyEntity) {
	        return modelMapper.map(companyEntity, HolidaysDto.class);
	    } 
}
