package com.orive.TimeSheet.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.TimeSheet.Dto.LeaveDto;
import com.orive.TimeSheet.Entity.LeavesEntity;
import com.orive.TimeSheet.Repository.LeavesRepository;

@Service
public class LeavesService {

private static final Logger logger=LoggerFactory.getLogger(LeavesService.class);
	
	@Autowired
	private LeavesRepository leavesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public LeaveDto createLeaves(LeaveDto companyDto) {
    	LeavesEntity companyEntity = convertToEntity(companyDto);
    	LeavesEntity savedCompany = leavesRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getLeaveId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<LeaveDto> getAllLeaves() {
        List<LeavesEntity> companyEntities = leavesRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<LeaveDto> getLeavesById(Long leaveId) {
        Optional<LeavesEntity> company = leavesRepository.findById(leaveId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", leaveId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public LeaveDto updateLeaves(Long leaveId, LeaveDto companyDto) {
        Optional<LeavesEntity> existingCompanyOptional = leavesRepository.findById(leaveId);
        if (existingCompanyOptional.isPresent()) {
        	LeavesEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            LeavesEntity updatedCompany = leavesRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getLeaveId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", leaveId);
            return null;
        }
    }
    
    // Delete
    public void deleteLeaves(Long leaveId) {
    	leavesRepository.deleteById(leaveId);
        logger.info("Deleted company with ID: {}", leaveId);
    }

    //count the total company
    public long countLeaves()
	 {
		 return leavesRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private LeavesEntity convertToEntity(LeaveDto companyDto)
    {
    	return modelMapper.map(companyDto, LeavesEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private LeaveDto convertToDTO(LeavesEntity companyEntity) {
        return modelMapper.map(companyEntity, LeaveDto.class);
    } 
}
