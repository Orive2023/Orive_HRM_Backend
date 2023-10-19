package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.ExpenceDto;
import com.orive.Organisation.Entity.ExpenceEntity;
import com.orive.Organisation.Repository.ExpenceRepository;



@Service
public class ExpenceService {

private static final Logger logger=LoggerFactory.getLogger(ExpenceService.class);
	
	@Autowired
	private ExpenceRepository expenceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public ExpenceDto createExpence(ExpenceDto companyDto) {
    	ExpenceEntity companyEntity = convertToEntity(companyDto);
    	ExpenceEntity savedCompany = expenceRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getExpenceId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<ExpenceDto> getAllExpence() {
        List<ExpenceEntity> companyEntities = expenceRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<ExpenceDto> getExpenceById(Long expenceId) {
        Optional<ExpenceEntity> company = expenceRepository.findById(expenceId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", expenceId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public ExpenceDto updateExpence(Long expenceId, ExpenceDto companyDto) {
        Optional<ExpenceEntity> existingCompanyOptional = expenceRepository.findById(expenceId);
        if (existingCompanyOptional.isPresent()) {
        	ExpenceEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            ExpenceEntity updatedCompany = expenceRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getExpenceId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", expenceId);
            return null;
        }
    }
    
    // Delete
    public void deleteExpence(Long expenceId) {
    	expenceRepository.deleteById(expenceId);
        logger.info("Deleted company with ID: {}", expenceId);
    }

    //count the total company
    public long countExpence()
	 {
		 return expenceRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private ExpenceEntity convertToEntity(ExpenceDto companyDto)
    {
    	return modelMapper.map(companyDto, ExpenceEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private ExpenceDto convertToDTO(ExpenceEntity companyEntity) {
        return modelMapper.map(companyEntity, ExpenceDto.class);
    } 
}
