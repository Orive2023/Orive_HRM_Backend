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
    public SetRolesDto createRoles(SetRolesDto companyDto) {
    	SetRolesEntity companyEntity = convertToEntity(companyDto);
    	SetRolesEntity savedCompany = setRolesRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getRolesId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<SetRolesDto> getAllRoles() {
        List<SetRolesEntity> companyEntities = setRolesRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<SetRolesDto> getRolesById(Long rolesId) {
        Optional<SetRolesEntity> company = setRolesRepository.findById(rolesId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", rolesId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public SetRolesDto updateRoles(Long rolesId, SetRolesDto companyDto) {
        Optional<SetRolesEntity> existingCompanyOptional = setRolesRepository.findById(rolesId);
        if (existingCompanyOptional.isPresent()) {
        	SetRolesEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            SetRolesEntity updatedCompany = setRolesRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getRolesId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", rolesId);
            return null;
        }
    }
    
    // Delete
    public void deleteRoles(Long rolesId) {
    	setRolesRepository.deleteById(rolesId);
        logger.info("Deleted company with ID: {}", rolesId);
    }

    //count the total company
    public long countRoles()
	 {
		 return setRolesRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private SetRolesEntity convertToEntity(SetRolesDto companyDto)
    {
    	return modelMapper.map(companyDto, SetRolesEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private SetRolesDto convertToDTO(SetRolesEntity companyEntity) {
        return modelMapper.map(companyEntity, SetRolesDto.class);
    } 
}
