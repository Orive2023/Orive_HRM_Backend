package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.PoliciesDto;
import com.orive.Organisation.Entity.PoliciesEntity;
import com.orive.Organisation.Repository.PoliciesRepository;



@Service
public class PoliciesService {

	private static final Logger logger=LoggerFactory.getLogger(LocationService.class);
	
	@Autowired
	private PoliciesRepository policiesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public PoliciesDto createPolicies(PoliciesDto companyDto) {
    	PoliciesEntity companyEntity = convertToEntity(companyDto);
    	PoliciesEntity savedCompany = policiesRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getPoliciesId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<PoliciesDto> getAllPolicies() {
        List<PoliciesEntity> companyEntities = policiesRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<PoliciesDto> getPoliciesById(Long policiesId) {
        Optional<PoliciesEntity> company = policiesRepository.findById(policiesId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", policiesId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public PoliciesDto updatePolicies(Long policiesId, PoliciesDto companyDto) {
        Optional<PoliciesEntity> existingCompanyOptional = policiesRepository.findById(policiesId);
        if (existingCompanyOptional.isPresent()) {
        	PoliciesEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            PoliciesEntity updatedCompany = policiesRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getPoliciesId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", policiesId);
            return null;
        }
    }
    
    // Delete
    public void deletePolicies(Long policiesId) {
    	policiesRepository.deleteById(policiesId);
        logger.info("Deleted company with ID: {}", policiesId);
    }

    //count the total company
    public long countPolicies()
	 {
		 return policiesRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private PoliciesEntity convertToEntity(PoliciesDto companyDto)
    {
    	return modelMapper.map(companyDto, PoliciesEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private PoliciesDto convertToDTO(PoliciesEntity companyEntity) {
        return modelMapper.map(companyEntity, PoliciesDto.class);
    }
}
