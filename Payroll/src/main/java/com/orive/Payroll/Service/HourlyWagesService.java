package com.orive.Payroll.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Payroll.Dto.HourlyWagesDto;
import com.orive.Payroll.Entity.HourlyWagesEntity;
import com.orive.Payroll.Repository.HourlyWagesRepository;


@Service
public class HourlyWagesService {
	
private static final Logger logger=LoggerFactory.getLogger(HourlyWagesService.class);
	
	@Autowired
	private HourlyWagesRepository hourlyWagesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public HourlyWagesDto createHourlyWages(HourlyWagesDto hourlyWagesDto) {
    	HourlyWagesEntity  hourlyWagesEntity = convertToEntity(hourlyWagesDto);
    	HourlyWagesEntity savedHourlyWages = hourlyWagesRepository.save(hourlyWagesEntity);
        logger.info("Created HourlyWages with ID: {}", savedHourlyWages.getHourlyWagesId());
        return convertToDTO(savedHourlyWages);
    }

    // Read
    public List<HourlyWagesDto> getAllHourlyWages() {
        List<HourlyWagesEntity> hourlyWagesEntities = hourlyWagesRepository.findAll();
        logger.info("Retrieved {} HourlyWages from the database", hourlyWagesEntities.size());
        return hourlyWagesEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by HourlyWagesId
    public Optional<HourlyWagesDto> getHourlyWagesById(Long HourlyWagesId) {
        Optional<HourlyWagesEntity> hourlyWages = hourlyWagesRepository.findById(HourlyWagesId);
        if (hourlyWages.isPresent()) {
            return Optional.of(convertToDTO(hourlyWages.get()));
        } else {
            logger.warn("HourlyWages with ID {} not found", HourlyWagesId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public HourlyWagesDto updateHourlyWages(Long HourlyWagesId, HourlyWagesDto hourlyWagesDto) {
        Optional<HourlyWagesEntity> existingHourlyWagesOptional = hourlyWagesRepository.findById(HourlyWagesId);
        if (existingHourlyWagesOptional.isPresent()) {
        	HourlyWagesEntity existingHourlyWages= existingHourlyWagesOptional.get();
            modelMapper.map(hourlyWagesDto, existingHourlyWagesOptional);
            HourlyWagesEntity updatedHourlyWages = hourlyWagesRepository.save(existingHourlyWages);
            logger.info("Updated HourlyWages with ID: {}", updatedHourlyWages.getHourlyWagesId());
            return convertToDTO(updatedHourlyWages);
        } else {
            logger.warn("HourlyWages with ID {} not found for update", HourlyWagesId);
            return null;
        }
    }
    
    // Delete
    public void deleteHourlyWages(Long HourlyWagesId) {
    	hourlyWagesRepository.deleteById(HourlyWagesId);
        logger.info("Deleted HourlyWages with ID: {}", HourlyWagesId);
    }

    //count the total HourlyWages
    public long countHourlyWages()
	 {
		 return hourlyWagesRepository.count();
	 }
    
	// Helper method to convert HourlyWagesDTo to HourlyWagesEntity
    private HourlyWagesEntity convertToEntity(HourlyWagesDto hourlyWagesDto)
    {
    	return modelMapper.map(hourlyWagesDto, HourlyWagesEntity.class);
    }

 // Helper method to convert HourlyWagesEntity entity to HourlyWagesDTo
    private HourlyWagesDto convertToDTO(HourlyWagesEntity hourlyWagesEntity) {
        return modelMapper.map(hourlyWagesEntity, HourlyWagesDto.class);
    } 

}
