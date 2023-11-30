package com.orive.Organisation.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.orive.Organisation.Dto.PoliciesDto;
import com.orive.Organisation.Entity.PoliciesEntity;
import com.orive.Organisation.Repository.PoliciesRepository;
import com.orive.Organisation.Util.UploadPdfUtils;



@Service
public class PoliciesService {

	private static final Logger logger=LoggerFactory.getLogger(LocationService.class);
	
	@Autowired
	private PoliciesRepository policiesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
//    public PoliciesDto createPolicies(PoliciesDto policiesDto) {
//    	PoliciesEntity policiesEntity = convertToEntity(policiesDto);
//    	PoliciesEntity savedPolicies = policiesRepository.save(policiesEntity);
//        logger.info("Created Policies with ID: {}", savedPolicies.getPoliciesId());
//        return convertToDTO(savedPolicies);
//    }
	
	
	public String savePoliciesEntity(
			String companyName,
			String title,
			String description,
			String createdDate,
			MultipartFile file) {
		
		try {
			PoliciesEntity pdfData = policiesRepository.save(PoliciesEntity.builder()
					.companyName(companyName)
					.title(title)
					.description(description)
					.createdDate(createdDate)
					.uploadPdf(UploadPdfUtils.compressPdf(file.getBytes()))
					.build());
			
			 if (pdfData != null) {
		            return "File uploaded successfully: " + file.getOriginalFilename();
		        }
			
		}catch (Exception e) {
			// Handle the IOException appropriately (e.g., log it, return an error message)
	        return "Error uploading file: " + e.getMessage();
		}
		
		return null;
	}
			
	public byte[] downloadPdf(Long policiesId) {
		 Optional<PoliciesEntity> dbPdfData = policiesRepository.findById(policiesId);
	    
	    if (dbPdfData.isPresent()) {
	        return UploadPdfUtils.decompressPdf(dbPdfData.get().getUploadPdf());
	    } else {
	        // Handle the case where the candidate profile is not found
	        return null;
	    }
	}
	

    // Read
    public List<PoliciesDto> getAllPolicies() {
        List<PoliciesEntity> policiesEntities = policiesRepository.findAll();
        logger.info("Retrieved {} Policies from the database", policiesEntities.size());
        return policiesEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by PoliciesId
    public Optional<PoliciesDto> getPoliciesById(Long policiesId) {
        Optional<PoliciesEntity> policies = policiesRepository.findById(policiesId);
        if (policies.isPresent()) {
            return Optional.of(convertToDTO(policies.get()));
        } else {
            logger.warn("Policies with ID {} not found", policiesId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public PoliciesDto updatePolicies(Long policiesId, PoliciesDto policiesDto) {
        Optional<PoliciesEntity> existingPoliciesOptional = policiesRepository.findById(policiesId);
        if (existingPoliciesOptional.isPresent()) {
        	PoliciesEntity existingPolicies = existingPoliciesOptional.get();
        	existingPolicies.setTitle(policiesDto.getTitle());
            modelMapper.map(policiesDto, existingPoliciesOptional);
            PoliciesEntity updatedPolicies = policiesRepository.save(existingPolicies);
            logger.info("Updated Policies with ID: {}", updatedPolicies.getPoliciesId());
            return convertToDTO(updatedPolicies);
        } else {
            logger.warn("Policies with ID {} not found for update", policiesId);
            return null;
        }
    }
    
    // Delete
    public void deletePolicies(Long policiesId) {
    	policiesRepository.deleteById(policiesId);
        logger.info("Deleted Policies with ID: {}", policiesId);
    }

    //count the total Policies
    public long countPolicies()
	 {
		 return policiesRepository.count();
	 }
    
	// Helper method to convert PoliciesDTo to PoliciesEntity
    private PoliciesEntity convertToEntity(PoliciesDto policiesDto)
    {
    	return modelMapper.map(policiesDto, PoliciesEntity.class);
    }

    // Helper method to convert PoliciesEntity to PoliciesDTo
    private PoliciesDto convertToDTO(PoliciesEntity policiesEntity) {
        return modelMapper.map(policiesEntity, PoliciesDto.class);
    }
}
