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
    public LeaveDto createLeaves(LeaveDto leaveDto) {
    	LeavesEntity leavesEntity = convertToEntity(leaveDto);
    	LeavesEntity savedCompany = leavesRepository.save(leavesEntity);
        logger.info("Created Leaves with ID: {}", savedCompany.getLeaveId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<LeaveDto> getAllLeaves() {
        List<LeavesEntity> leavesEntities = leavesRepository.findAll();
        logger.info("Retrieved {} Leaves from the database", leavesEntities.size());
        return leavesEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by LeavesId
    public Optional<LeaveDto> getLeavesById(Long leaveId) {
        Optional<LeavesEntity> leaves = leavesRepository.findById(leaveId);
        if (leaves.isPresent()) {
            return Optional.of(convertToDTO(leaves.get()));
        } else {
            logger.warn("Leaves with ID {} not found", leaveId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public LeaveDto updateLeaves(Long leaveId, LeaveDto leaveDto) {
        Optional<LeavesEntity> existingLeavesOptional = leavesRepository.findById(leaveId);
        if (existingLeavesOptional.isPresent()) {
        	LeavesEntity existingLeave = existingLeavesOptional.get();
            existingLeave.setEmployeeName(leaveDto.getEmployeeName());
        	existingLeave.setStartDate(leaveDto.getStartDate());
        	existingLeave.setEndDate(leaveDto.getEndDate());
        	modelMapper.map(leaveDto, existingLeavesOptional);
            LeavesEntity updatedLeave = leavesRepository.save(existingLeave);
            logger.info("Updated Leaves with ID: {}", updatedLeave.getLeaveId());
            return convertToDTO(updatedLeave);
        } else {
            logger.warn("Leaves with ID {} not found for update", leaveId);
            return null;
        }
    }
    
    // Delete
    public void deleteLeaves(Long leaveId) {
    	leavesRepository.deleteById(leaveId);
        logger.info("Deleted Leaves with ID: {}", leaveId);
    }

    //count the total Leaves
    public long countLeaves()
	 {
		 return leavesRepository.count();
	 }
    
	// Helper method to convert LeavesDTo to LeavesEntity
    private LeavesEntity convertToEntity(LeaveDto leaveDto)
    {
    	return modelMapper.map(leaveDto, LeavesEntity.class);
    }

    // Helper method to convert LeavesEntity entity to LeavesEntity
    private LeaveDto convertToDTO(LeavesEntity leavesEntity) {
        return modelMapper.map(leavesEntity, LeaveDto.class);
    } 
}
