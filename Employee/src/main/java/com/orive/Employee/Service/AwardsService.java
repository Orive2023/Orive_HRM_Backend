package com.orive.Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.AwardsDto;
import com.orive.Employee.Entity.AwardsEntity;
import com.orive.Employee.Repository.AwardsRepository;



@Service
public class AwardsService {

private static final Logger logger=LoggerFactory.getLogger(AwardsService.class);
	
	@Autowired
	private AwardsRepository awardsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public AwardsDto createAwards(AwardsDto companyDto) {
    	AwardsEntity companyEntity = convertToEntity(companyDto);
    	AwardsEntity savedCompany = awardsRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getAwardId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<AwardsDto> getAllAwards() {
        List<AwardsEntity> companyEntities = awardsRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<AwardsDto> getAwardsById(Long awardId) {
        Optional<AwardsEntity> company = awardsRepository.findById(awardId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", awardId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public AwardsDto updateAwards(Long awardId, AwardsDto companyDto) {
        Optional<AwardsEntity> existingCompanyOptional = awardsRepository.findById(awardId);
        if (existingCompanyOptional.isPresent()) {
        	AwardsEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            AwardsEntity updatedCompany = awardsRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getAwardId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", awardId);
            return null;
        }
    }
    
    // Delete
    public void deleteAwards(Long awardId) {
    	awardsRepository.deleteById(awardId);
        logger.info("Deleted company with ID: {}", awardId);
    }

    //count the total company
    public long countAwards()
	 {
		 return awardsRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private AwardsEntity convertToEntity(AwardsDto companyDto)
    {
    	return modelMapper.map(companyDto, AwardsEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private AwardsDto convertToDTO(AwardsEntity companyEntity) {
        return modelMapper.map(companyEntity, AwardsDto.class);
    } 
}
