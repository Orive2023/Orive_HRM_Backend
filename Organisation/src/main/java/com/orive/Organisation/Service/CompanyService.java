package com.orive.Organisation.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import com.orive.Organisation.Entity.LocationEntity;
import com.orive.Organisation.Exceptions.ResourceNotFoundException;
import com.orive.Organisation.Repository.CompanyRepository;
import com.orive.Organisation.Util.ImageUtils;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CompanyService {

	private static final Logger logger=LoggerFactory.getLogger(CompanyService.class);
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	// Create
	 public String uploadImage(
			 String companyName,
			 String companyType,
			 String legalOrTradingName,
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
			 String createdDate,
//			 String status,
//			 String approvedBy,
			 MultipartFile file) throws IOException {

	        CompanyEntity imageData = companyRepository.save(CompanyEntity.builder()
	                .companyName(companyName)
	                .companyType(companyType)
	                .legalOrTradingName(legalOrTradingName)
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
	                .createdDate(createdDate)
//	                .status(status)
//	                .approvedBy(approvedBy)
	                .uploadLogo(ImageUtils.compressImage(file.getBytes())).build());
	        if (imageData != null) {
	            return "file uploaded successfully : " + file.getOriginalFilename();
	        }
	        return null;
	    }
	 
	 //Download Logo
	 public byte[] downloadImage(String companyName){
	        Optional<CompanyEntity> dbImageData = companyRepository.findByCompanyName(companyName);
	        byte[] images=ImageUtils.decompressImage(dbImageData.get().getUploadLogo());
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
    public CompanyEntity getCompanyById(Long companyId) {
        CompanyEntity company = companyRepository.findById(companyId)
                .orElseThrow(() -> {
                    logger.warn("Company with ID {} not found", companyId);
                    return new ResourceNotFoundException("Company with ID " + companyId + " not found");
                });
//        ArrayList<LocationEntity> ratingsOfUser = restTemplate.getForObject("http://localhost:5000/candidateProfile/getcareer/" + company.get(), ArrayList.class);
//        logger.info("{} ", ratingsOfUser);
//        company.setLocationEntities(ratingsOfUser);

        return company;
    }
    
 // Update list by id
    public void partialUpdateCompany(Long companyId, CompanyEntity companyEntity) {
        Optional<CompanyEntity> existingCompanyOptional = companyRepository.findById(companyId);
        if (existingCompanyOptional.isPresent()) {
            CompanyEntity existingCompany = existingCompanyOptional.get();

            // Update fields conditionally only if they are not null in companyEntity
            if (companyEntity.getCompanyName() != null) {
                existingCompany.setCompanyName(companyEntity.getCompanyName());
            }

            if (companyEntity.getContactNumber() != null) {
                existingCompany.setContactNumber(companyEntity.getContactNumber());
            }

            if (companyEntity.getEmail() != null) {
                existingCompany.setEmail(companyEntity.getEmail());
            }

            if (companyEntity.getGst() != null) {
                existingCompany.setGst(companyEntity.getGst());
            }
            
            if (companyEntity.getCin() != null) {
                existingCompany.setCin(companyEntity.getCin());
            }
            
            if (companyEntity.getUan() != null) {
                existingCompany.setUan(companyEntity.getUan());
            }
            // Save the updated entity
            companyRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", existingCompany.getCompanyId());
        } else {
            logger.warn("Company with ID {} not found for update", companyId);
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
//    //ALL DETAILS BY COMAPNYNAME
//    public List<CompanyEntity> getAllLocationsByCompanyName(String companyName) {
//    	logger.info("Request to get all Company for companyname: " + companyName);
//        List<CompanyEntity> locations = companyRepository.findAllByCompanyName(companyName);
//
//        if (locations.isEmpty()) {
//        	logger.warn("No Company found for companyname: " + companyName);
//            throw new ResourceNotFoundException("No Company found for companyname: " + companyName);
//        } else {
//        	logger.info("Retrieved " + locations.size() + " locations for companyname: " + companyName);
//        }
//
//        return locations;
//    }
    
    
    
    
    
    
    
    
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
