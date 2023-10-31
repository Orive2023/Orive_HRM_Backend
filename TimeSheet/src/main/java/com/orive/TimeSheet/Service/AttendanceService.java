package com.orive.TimeSheet.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.TimeSheet.Dto.AttendanceDto;
import com.orive.TimeSheet.Dto.HolidaysDto;
import com.orive.TimeSheet.Entity.AttendanceEntity;
import com.orive.TimeSheet.Entity.HolidaysEntity;
import com.orive.TimeSheet.Repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public AttendanceDto createsAttendances(AttendanceDto attendanceDto) {
    	AttendanceEntity attendanceEntity = convertToEntity(attendanceDto);
    	AttendanceEntity savedAttendances = attendanceRepository.save(attendanceEntity);
        logger.info("Created Attendance with ID: {}", savedAttendances.getAttendanceId());
        return convertToDTO(savedAttendances);
    }

    // Read
    public List<AttendanceDto> getAllAttendances() {
        List<AttendanceEntity> attendanceEntities = attendanceRepository.findAll();
        logger.info("Retrieved {} Attendance from the database", attendanceEntities.size());
        return attendanceEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by AttendanceId
    public Optional<AttendanceDto> getAttendanceById(Long attendanceId) {
        Optional<AttendanceEntity> attendances = attendanceRepository.findById(attendanceId);
        if (attendances.isPresent()) {
            return Optional.of(convertToDTO(attendances.get()));
        } else {
            logger.warn("Attendance with ID {} not found", attendanceId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public AttendanceDto updateAttendances(Long attendanceId, AttendanceDto attendanceDto) {
        Optional<AttendanceEntity> existingAttendanceOptional = attendanceRepository.findById(attendanceId);
        if (existingAttendanceOptional.isPresent()) {
        	AttendanceEntity existingAttendance = existingAttendanceOptional.get();
            modelMapper.map(attendanceDto, existingAttendanceOptional);
            AttendanceEntity updatedAttendance= attendanceRepository.save(existingAttendance);
            logger.info("Updated Attendance with ID: {}", updatedAttendance.getAttendanceId());
            return convertToDTO(updatedAttendance);
        } else {
            logger.warn("Attendance with ID {} not found for update", attendanceId);
            return null;
        }
    }
    
    // Delete
    public void deleteAttendances(Long attendanceId) {
    	attendanceRepository.deleteById(attendanceId);
        logger.info("Deleted Attendance with ID: {}", attendanceId);
    }

    //count the total Attendance
    public long countAttendances()
	 {
		 return attendanceRepository.count();
	 }
    
	// Helper method to convert AttendanceDTo to AttendanceEntity
    private AttendanceEntity convertToEntity(AttendanceDto attendanceDto)
    {
    	return modelMapper.map(attendanceDto, AttendanceEntity.class);
    }

    // Helper method to convert AttendanceEntity entity to AttendanceDTo
    private AttendanceDto convertToDTO(AttendanceEntity attendanceEntity) {
        return modelMapper.map(attendanceEntity, AttendanceDto.class);
    } 

}
