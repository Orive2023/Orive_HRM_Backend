package com.orive.Organisation.Service;

import java.io.IOException;
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
import com.orive.Organisation.Util.ImageUtils;

import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyService {

	private static final Logger logger=LoggerFactory.getLogger(CompanyService.class);
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
//	public CompanyDto createCompany(MultipartFile file, CompanyDto companyDto) {
//	    try {
//	        // Convert CompanyDto to CompanyEntity
//	        CompanyEntity companyEntity = convertToEntity(companyDto);
//
//	        // Compress and set the company logo from the MultipartFile
//	        companyEntity.setCompanyLogo(ImageUtils.compressImage(file.getBytes()));
//
//	        // Save the company entity with the compressed logo
//	        CompanyEntity savedCompany = companyRepository.save(companyEntity);
//
//	        if (savedCompany != null) {
//	            // Log the creation of the company
//	            logger.info("Created Company with ID: {}", savedCompany.getCompanyId());
//
//	            // Convert the saved entity back to DTO for response
//	            return convertToDTO(savedCompany);
//	        } else {
//	            // Handle the case where the company is not saved successfully
//	            return null;
//	        }
//	    } catch (IOException e) {
//	        // Handle IOException (e.g., if there's an issue reading or compressing the image)
//	        logger.error("Error creating company with logo", e);
//	        return null;
//	    }
//	}
	
	 public String uploadImage(
			 String companyName,
			 String incomeTaxNumber,
			 String companyType,
			 String legalOrTrandingName,
			 String address,
			 String registrationNumber,
			 Long contactNumber,
			 String email,
			 String website,
			 String city,
			 String state,
			 int zipCode,
			 String country,
			 String cin,
			 String gst,
			 String uan,
			 String status,
			 String approvedBy,
			 MultipartFile file) throws IOException {

	        CompanyEntity imageData = companyRepository.save(CompanyEntity.builder()
	                .companyName(companyName)
	                .incomeTaxNumber(incomeTaxNumber)
	                .companyType(companyType)
	                .legalOrTrandingName(legalOrTrandingName)
	                .address(address)
	                .registrationNumber(registrationNumber)
	                .contactNumber(contactNumber)
	                .email(email)
	                .website(website)
	                .city(city)
	                .state(state)
	                .zipCode(zipCode)
	                .country(country)              
	                .cin(cin)
	                .gst(gst)
	                .uan(uan)
	                .status(status)
	                .approvedBy(approvedBy)
	                .companyLogo(ImageUtils.compressImage(file.getBytes())).build());
	        if (imageData != null) {
	            return "file uploaded successfully : " + file.getOriginalFilename();
	        }
	        return null;
	    }
	 public byte[] downloadImage(String companyName){
	        Optional<CompanyEntity> dbImageData = companyRepository.findByCompanyName(companyName);
	        byte[] images=ImageUtils.decompressImage(dbImageData.get().getCompanyLogo());
	        return images;
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
        	existingCompany.setCompanyName(companyDto.getCompanyName());
        	existingCompany.setCompanyType(companyDto.getCompanyType());
        	existingCompany.setLegalOrTrandingName(companyDto.getLegalOrTrandingName());
        	existingCompany.setContactNumber(companyDto.getContactNumber());
        	existingCompany.setEmail(companyDto.getEmail());
        	existingCompany.setWebsite(companyDto.getWebsite());
        	existingCompany.setAddress(companyDto.getAddress());
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
    
	// Helper method to convert CompanyDTo to CompanyEntity
    private CompanyEntity convertToEntity(CompanyDto companyDto)
    {
    	return modelMapper.map(companyDto, CompanyEntity.class);
    }

    // Helper method to convert CompanyEntity  to CompanyDTo
    private CompanyDto convertToDTO(CompanyEntity companyEntity) {
        return modelMapper.map(companyEntity, CompanyDto.class);
    } 
 
}
