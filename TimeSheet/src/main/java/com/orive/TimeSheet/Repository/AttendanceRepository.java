package com.orive.TimeSheet.Repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orive.TimeSheet.Entity.AttendanceEntity;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

//Count the employees present today
	@Query("SELECT COUNT(a) FROM AttendanceEntity a WHERE a.date = CURRENT_DATE()")
	long countPresentEmployeesToday();
	
//	@Query("SELECT l FROM AttendanceEntity l WHERE l.employeeName = :employeeName AND 1.date = :date")
//	Optional<AttendanceEntity> findByEmployeeNameAndDate(String employeeName, LocalDate date);
	
	
	@Query("SELECT a FROM AttendanceEntity a WHERE a.employeeName = :employeeName AND a.date = :date")
	Optional<AttendanceEntity> findByEmployeeNameAndDate(@Param("employeeName") String employeeName, @Param("date") LocalDate date);
	
}
