package com.orive.Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.SetRolesDto;
import com.orive.Employee.Entity.SetRolesEntity;
import com.orive.Employee.Repository.SetRolesRepository;



@Service
public class SetRolesService {

	private static final Logger logger=LoggerFactory.getLogger(SetRolesService.class);
	
	@Autowired
	private SetRolesRepository setRolesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public SetRolesDto createRoles(SetRolesDto setRolesDto) {
    	SetRolesEntity setRolesEntity = convertToEntity(setRolesDto);
    	SetRolesEntity savedSetRoles = setRolesRepository.save(setRolesEntity);
        logger.info("Created SetRoles with ID: {}", savedSetRoles.getRolesId());
        return convertToDTO(savedSetRoles);
    }

    // Read
    public List<SetRolesDto> getAllRoles() {
        List<SetRolesEntity> setRolesEntities = setRolesRepository.findAll();
        logger.info("Retrieved {} SetRoles from the database", setRolesEntities.size());
        return setRolesEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by SetRolesId
    public Optional<SetRolesDto> getRolesById(Long rolesId) {
        Optional<SetRolesEntity> setRoles = setRolesRepository.findById(rolesId);
        if (setRoles.isPresent()) {
            return Optional.of(convertToDTO(setRoles.get()));
        } else {
            logger.warn("SetRoles with ID {} not found", rolesId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public SetRolesDto updateRoles(Long rolesId, SetRolesDto setRolesDto) {
        Optional<SetRolesEntity> existingSetRolesOptional = setRolesRepository.findById(rolesId);
        if (existingSetRolesOptional.isPresent()) {
        	SetRolesEntity existingSetRoles = existingSetRolesOptional.get();
            modelMapper.map(setRolesDto, existingSetRolesOptional);
            SetRolesEntity updatedSetRoles = setRolesRepository.save(existingSetRoles);
            logger.info("Updated SetRoles with ID: {}", updatedSetRoles.getRolesId());
            return convertToDTO(updatedSetRoles);
        } else {
            logger.warn("SetRoles with ID {} not found for update", rolesId);
            return null;
        }
    }
    
    // Delete
    public void deleteRoles(Long rolesId) {
    	setRolesRepository.deleteById(rolesId);
        logger.info("Deleted SetRoles with ID: {}", rolesId);
    }

    //count the total SetRoles
    public long countRoles()
	 {
		 return setRolesRepository.count();
	 }
    
	// Helper method to convert SetRolesDTo to SetRolesEntity
    private SetRolesEntity convertToEntity(SetRolesDto setRolesDto)
    {
    	return modelMapper.map(setRolesDto, SetRolesEntity.class);
    }

    // Helper method to convert SetRolesEntity to SetRolesDTo
    private SetRolesDto convertToDTO(SetRolesEntity setRolesEntity) {
        return modelMapper.map(setRolesEntity, SetRolesDto.class);
    } 
}
