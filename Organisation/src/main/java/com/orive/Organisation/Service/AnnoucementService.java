package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.AnnoucementsDto;
import com.orive.Organisation.Entity.AnnoucementsEntity;
import com.orive.Organisation.Repository.AnnoucementsRepository;



@Service
public class AnnoucementService {

    private static final Logger logger=LoggerFactory.getLogger(AnnoucementService.class);
	
	@Autowired
	private AnnoucementsRepository annoucementsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public AnnoucementsDto createAnnouncements(AnnoucementsDto companyDto) {
    	AnnoucementsEntity companyEntity = convertToEntity(companyDto);
    	AnnoucementsEntity savedCompany = annoucementsRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getAnnouncementsId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<AnnoucementsDto> getAllAnnouncements() {
        List<AnnoucementsEntity> companyEntities = annoucementsRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<AnnoucementsDto> getAnnouncementsById(Long announcementsId) {
        Optional<AnnoucementsEntity> company = annoucementsRepository.findById(announcementsId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", announcementsId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public AnnoucementsDto updateAnnouncements(Long announcementsId, AnnoucementsDto companyDto) {
        Optional<AnnoucementsEntity> existingCompanyOptional = annoucementsRepository.findById(announcementsId);
        if (existingCompanyOptional.isPresent()) {
        	AnnoucementsEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            AnnoucementsEntity updatedCompany = annoucementsRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getAnnouncementsId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", announcementsId);
            return null;
        }
    }
    
    // Delete
    public void deleteAnnouncements(Long announcementsId) {
    	annoucementsRepository.deleteById(announcementsId);
        logger.info("Deleted company with ID: {}", announcementsId);
    }

    //count the total company
    public long countAnnouncements()
	 {
		 return annoucementsRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private AnnoucementsEntity convertToEntity(AnnoucementsDto companyDto)
    {
    	return modelMapper.map(companyDto, AnnoucementsEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private AnnoucementsDto convertToDTO(AnnoucementsEntity companyEntity) {
        return modelMapper.map(companyEntity, AnnoucementsDto.class);
    } 
}
