package com.orive.TimeSheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orive.TimeSheet.Entity.AttendanceEntity;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

//Count the employees present today
	@Query("SELECT COUNT(a) FROM AttendanceEntity a WHERE a.date = CURRENT_DATE()")
	long countPresentEmployeesToday();
}
