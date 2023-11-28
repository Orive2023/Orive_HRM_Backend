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
	    public HolidaysDto createHolidays(HolidaysDto holidaysDto) {
	    	HolidaysEntity holidaysEntity = convertToEntity(holidaysDto);
	    	HolidaysEntity savedHolidays = holidaysRepository.save(holidaysEntity);
	        logger.info("Created Holidays with ID: {}", savedHolidays.getHolidaysId());
	        return convertToDTO(savedHolidays);
	    }

	    // Read
	    public List<HolidaysDto> getAllHolidays() {
	        List<HolidaysEntity> holidaysEntities = holidaysRepository.findAll();
	        logger.info("Retrieved {} Holidays from the database", holidaysEntities.size());
	        return holidaysEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by HolidaysId
	    public Optional<HolidaysDto> getHolidaysById(Long holidaysId) {
	        Optional<HolidaysEntity> holidays = holidaysRepository.findById(holidaysId);
	        if (holidays.isPresent()) {
	            return Optional.of(convertToDTO(holidays.get()));
	        } else {
	            logger.warn("Holidays with ID {} not found", holidaysId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public HolidaysDto updateHolidays(Long holidaysId, HolidaysDto holidaysDto) {
	        Optional<HolidaysEntity> existingHolidayOptional = holidaysRepository.findById(holidaysId);
	        if (existingHolidayOptional.isPresent()) {
	        	HolidaysEntity existingHoliday = existingHolidayOptional.get();
	            existingHoliday.setEventName(holidaysDto.getEventName());
	        	existingHoliday.setStatus(holidaysDto.getStatus());	
	        	modelMapper.map(holidaysDto, existingHolidayOptional);
	            HolidaysEntity updatedHoliday = holidaysRepository.save(existingHoliday);
	            logger.info("Updated Holidays with ID: {}", updatedHoliday.getHolidaysId());
	            return convertToDTO(updatedHoliday);
	        } else {
	            logger.warn("Holidays with ID {} not found for update", holidaysId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteHolidays(Long holidaysId) {
	    	holidaysRepository.deleteById(holidaysId);
	        logger.info("Deleted Holidays with ID: {}", holidaysId);
	    }

	    //count the total company
	    public long countHolidays()
		 {
			 return holidaysRepository.count();
		 }
	    
		// Helper method to convert HolidaysDTo to  Holidaysentity
	    private HolidaysEntity convertToEntity(HolidaysDto holidaysDto)
	    {
	    	return modelMapper.map(holidaysDto, HolidaysEntity.class);
	    }

	    // Helper method to convert HolidaysEntity entity to HolidaysDTo
	    private HolidaysDto convertToDTO(HolidaysEntity holidaysEntity) {
	        return modelMapper.map(holidaysEntity, HolidaysDto.class);
	    } 
}
