package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.CompanyDto;
import com.orive.Organisation.Entity.CompanyEntity;
import com.orive.Organisation.Repository.CompanyRepository;

@Service
public class CompanyService {

	private static final Logger logger=LoggerFactory.getLogger(CompanyService.class);
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public CompanyDto createCompany(CompanyDto companyDto) {
    	CompanyEntity companyEntity = convertToEntity(companyDto);
        CompanyEntity savedCompany = companyRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getCompanyId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<CompanyDto> getAllCompany() {
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<CompanyDto> getCompanyById(Long companyId) {
        Optional<CompanyEntity> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", companyId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public CompanyDto updateCompany(Long companyId, CompanyDto companyDto) {
        Optional<CompanyEntity> existingCompanyOptional = companyRepository.findById(companyId);
        if (existingCompanyOptional.isPresent()) {
        	CompanyEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            CompanyEntity updatedCompany = companyRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getCompanyId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", companyId);
            return null;
        }
    }
    
    // Delete
    public void deleteCompany(Long companyId) {
    	companyRepository.deleteById(companyId);
        logger.info("Deleted company with ID: {}", companyId);
    }

    //count the total company
    public long countCompany()
	 {
		 return companyRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private CompanyEntity convertToEntity(CompanyDto companyDto)
    {
    	return modelMapper.map(companyDto, CompanyEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private CompanyDto convertToDTO(CompanyEntity companyEntity) {
        return modelMapper.map(companyEntity, CompanyDto.class);
    } 
 
}
