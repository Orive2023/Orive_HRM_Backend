package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orive.Organisation.Dto.DesignationDto;
import com.orive.Organisation.Entity.DesignationEntity;
import com.orive.Organisation.Repository.DesignationRepository;

@Service
public class DesignationService {

	private static final Logger logger=LoggerFactory.getLogger(DesignationService.class);
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public DesignationDto createDesignation(DesignationDto companyDto) {
    	DesignationEntity companyEntity = convertToEntity(companyDto);
    	DesignationEntity savedCompany = designationRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getDesignationId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<DesignationDto> getAllDesignation() {
        List<DesignationEntity> companyEntities = designationRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<DesignationDto> getDesignationById(Long designationId) {
        Optional<DesignationEntity> company = designationRepository.findById(designationId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", designationId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public DesignationDto updateDesignation(Long designationId, DesignationDto companyDto) {
        Optional<DesignationEntity> existingCompanyOptional = designationRepository.findById(designationId);
        if (existingCompanyOptional.isPresent()) {
        	DesignationEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            DesignationEntity updatedCompany = designationRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getDesignationId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", designationId);
            return null;
        }
    }
    
    // Delete
    public void deleteDesignation(Long designationId) {
    	designationRepository.deleteById(designationId);
        logger.info("Deleted company with ID: {}", designationId);
    }

    //count the total company
    public long countDesignation()
	 {
		 return designationRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private DesignationEntity convertToEntity(DesignationDto companyDto)
    {
    	return modelMapper.map(companyDto, DesignationEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private DesignationDto convertToDTO(DesignationEntity companyEntity) {
        return modelMapper.map(companyEntity, DesignationDto.class);
    } 
	
}
