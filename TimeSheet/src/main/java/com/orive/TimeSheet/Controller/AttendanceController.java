package com.orive.TimeSheet.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.orive.TimeSheet.Dto.AttendanceDto;
import com.orive.TimeSheet.Dto.HolidaysDto;
import com.orive.TimeSheet.Service.AttendanceService;

@RestController
@RequestMapping(value = "attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	
	@Autowired
	private AttendanceService attendanceService;
	
	// Create a new Attendance
//    @PostMapping("/create/attendance")
//    public ResponseEntity<AttendanceDto> createAttendance(@RequestBody AttendanceDto attendanceDto) {
//    	AttendanceDto createdAttendance = attendanceService.createsAttendances(attendanceDto);
//        logger.info("Created Attendance with name: {}", createdAttendance.getEmployeeName());
//        return new ResponseEntity<>(createdAttendance, HttpStatus.CREATED);
//    }
	
	
	  @PostMapping("/create/attendance")
	    public ResponseEntity<String> saveAttendanceEntity(
	    		@RequestParam String employeeName,
	    		@RequestParam LocalTime clockIn,
	    		@RequestParam LocalTime clockOut,
	    		@RequestParam Long late,
	    		@RequestParam Long earlyLeaving,
	    		@RequestParam Long overTime,
	    		@RequestParam Long totalWork,
	    		@RequestParam Long totalRest,
	    		@RequestParam LocalDate date,
	    	    @RequestParam("file") MultipartFile file){
	    	
	    	String result = attendanceService.saveAttendanceEntity( 
	    			employeeName, clockIn, clockOut, late, earlyLeaving, overTime, totalWork, totalRest, date, file );
	    
	    	if(result != null) {
	    		 return new ResponseEntity<>(result, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Failed to save Attendance entity", HttpStatus.INTERNAL_SERVER_ERROR);
	       
	    	}
	    }
	    
	    
	    @GetMapping("/download/{attendanceId}")
	    public ResponseEntity<byte[]> downloadsDocs(@PathVariable Long attendanceId) {
	        byte[] doc = attendanceService.downloadPdf(attendanceId);

	        if (doc != null) {
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_PDF);
	            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(attendanceId + "_attendance.pdf").build());
	            return new ResponseEntity<>(doc, headers, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	
	
	

    // Get all Attendance   
    @GetMapping("/get/attendance")
    public ResponseEntity<List<AttendanceDto>> getAllAttendance() {
        List<AttendanceDto> attendance = attendanceService.getAllAttendances();
        logger.info("Retrieved {} Attendance from the database", attendance.size());
        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }

    // Get Attendance by ID
    @GetMapping("/get/{attendanceId}")
    public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable Long attendanceId) {
        Optional<AttendanceDto> attendance = attendanceService.getAttendanceById(attendanceId);
        if (attendance.isPresent()) {
            logger.info("Retrieved Attendance with ID: {}", attendanceId);
            return new ResponseEntity<>(attendance.get(), HttpStatus.OK);
        } else {
            logger.warn("Attendance with ID {} not found", attendanceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update Attendance by ID
    @PutMapping("/update/{attendanceId}")
    public ResponseEntity<AttendanceDto> updateAttendance(@PathVariable Long attendanceId, @RequestBody AttendanceDto updatedAttendanceDto) {
    	AttendanceDto updatedAttendance = attendanceService.updateAttendances(attendanceId, updatedAttendanceDto);
        if (updatedAttendance != null) {
            logger.info("Updated Attendance with ID: {}", attendanceId);
            return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
        } else {
            logger.warn("Attendance with ID {} not found for update", attendanceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    // Delete Attendance by ID
    @DeleteMapping("/delete/{attendanceId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long attendanceId) {
  	  attendanceService.deleteAttendances(attendanceId);
        logger.info("Deleted Attendance with ID: {}", attendanceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
    //count the total Attendance
	    @GetMapping("/count/attendance")
	    public long countAttendance()
	    {
	    	return attendanceService.countAttendances();
	    }

	    //count the total Attendance of employees present today    
	    @GetMapping("/count/present/attendance")
	    public long countPresentEmployeesToday()
	    {
	    	return attendanceService.countPresentEmployeesToday();
	    }
}

