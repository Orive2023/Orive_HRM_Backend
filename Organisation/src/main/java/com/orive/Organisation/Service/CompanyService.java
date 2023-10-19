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
    	CompanyEntity supplierEntity = convertToEntity(companyDto);
        CompanyEntity savedSupplier = companyRepository.save(supplierEntity);
        logger.info("Created supplier with ID: {}", savedSupplier.getCompanyId());
        return convertToDTO(savedSupplier);
    }

    // Read
    public List<CompanyDto> getAllCompany() {
        List<CompanyEntity> suppliers = companyRepository.findAll();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return suppliers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<CompanyDto> getCompanyById(Long companyId) {
        Optional<CompanyEntity> supplier = companyRepository.findById(companyId);
        if (supplier.isPresent()) {
            return Optional.of(convertToDTO(supplier.get()));
        } else {
            logger.warn("Supplier with ID {} not found", companyId);
            return Optional.empty();
        }
    }
    
    
 
    
 // Update list by id
    public CompanyDto updateCompany(Long companyId, CompanyDto companyDto) {
        Optional<CompanyEntity> existingSupplierOptional = companyRepository.findById(companyId);
        if (existingSupplierOptional.isPresent()) {
        	CompanyEntity existingSupplier = existingSupplierOptional.get();
            modelMapper.map(companyDto, existingSupplier);
            CompanyEntity updatedSupplier = companyRepository.save(existingSupplier);
            logger.info("Updated supplier with ID: {}", updatedSupplier.getCompanyId());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with ID {} not found for update", companyId);
            return null;
        }
    }
    
   


    // Delete
    public void deleteCompany(Long companyId) {
    	companyRepository.deleteById(companyId);
        logger.info("Deleted supplier with ID: {}", companyId);
    }

    //count the total supplierlist
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
