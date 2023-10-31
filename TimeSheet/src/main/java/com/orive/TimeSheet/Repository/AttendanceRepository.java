package com.orive.TimeSheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.TimeSheet.Entity.AttendanceEntity;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

}
