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
    public LocationDto createLocation(LocationDto locationDto) {
    	LocationEntity locationEntity = convertToEntity(locationDto);
    	LocationEntity savedLocation = locationRepository.save(locationEntity);
        logger.info("Created Location with ID: {}", savedLocation.getLocationId());
        return convertToDTO(savedLocation);
    }

    // Read
    public List<LocationDto> getAllLocation() {
        List<LocationEntity> locationEntities = locationRepository.findAll();
        logger.info("Retrieved {} location from the database", locationEntities.size());
        return locationEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by LocationId
    public Optional<LocationDto> getLocationById(Long locationId) {
        Optional<LocationEntity> location = locationRepository.findById(locationId);
        if (location.isPresent()) {
            return Optional.of(convertToDTO(location.get()));
        } else {
            logger.warn("Location with ID {} not found", locationId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public LocationDto updateLocation(Long locationId, LocationDto locationDto) {
        Optional<LocationEntity> existingLocationOptional = locationRepository.findById(locationId);
        if (existingLocationOptional.isPresent()) {
        	LocationEntity existingLocation = existingLocationOptional.get();
            modelMapper.map(locationDto, existingLocationOptional);
            LocationEntity updatedLocation = locationRepository.save(existingLocation);
            logger.info("Updated Location with ID: {}", updatedLocation.getLocationId());
            return convertToDTO(updatedLocation);
        } else {
            logger.warn("Location with ID {} not found for update", locationId);
            return null;
        }
    }
    
    // Delete
    public void deleteLocation(Long locationId) {
    	locationRepository.deleteById(locationId);
        logger.info("Deleted location with ID: {}", locationId);
    }

    //count the total Location
    public long countLocation()
	 {
		 return locationRepository.count();
	 }
    
	// Helper method to convert LocationDTo to Location entity
    private LocationEntity convertToEntity(LocationDto locationDto)
    {
    	return modelMapper.map(locationDto, LocationEntity.class);
    }

    // Helper method to convert Location Entity entity to LocationDTo
    private LocationDto convertToDTO(LocationEntity locationEntity) {
        return modelMapper.map(locationEntity, LocationDto.class);
    } 
}
