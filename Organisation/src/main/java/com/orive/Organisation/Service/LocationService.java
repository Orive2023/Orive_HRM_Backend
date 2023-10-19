package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.LocationDto;
import com.orive.Organisation.Entity.LocationEntity;
import com.orive.Organisation.Repository.LocationRepository;

@Service
public class LocationService {

   private static final Logger logger=LoggerFactory.getLogger(LocationService.class);
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public LocationDto createLocation(LocationDto companyDto) {
    	LocationEntity companyEntity = convertToEntity(companyDto);
    	LocationEntity savedCompany = locationRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getLocationId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<LocationDto> getAllLocation() {
        List<LocationEntity> companyEntities = locationRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<LocationDto> getLocationById(Long locationId) {
        Optional<LocationEntity> company = locationRepository.findById(locationId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", locationId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public LocationDto updateLocation(Long locationId, LocationDto companyDto) {
        Optional<LocationEntity> existingCompanyOptional = locationRepository.findById(locationId);
        if (existingCompanyOptional.isPresent()) {
        	LocationEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            LocationEntity updatedCompany = locationRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getLocationId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", locationId);
            return null;
        }
    }
    
    // Delete
    public void deleteLocation(Long locationId) {
    	locationRepository.deleteById(locationId);
        logger.info("Deleted company with ID: {}", locationId);
    }

    //count the total company
    public long countLocation()
	 {
		 return locationRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private LocationEntity convertToEntity(LocationDto companyDto)
    {
    	return modelMapper.map(companyDto, LocationEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private LocationDto convertToDTO(LocationEntity companyEntity) {
        return modelMapper.map(companyEntity, LocationDto.class);
    } 
}
