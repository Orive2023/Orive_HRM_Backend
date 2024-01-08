package com.orive.WorkSheet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.orive.WorkSheet.Entity.WorkSheetEntity;

public interface WorkSheetRepository extends JpaRepository<WorkSheetEntity, Long>{
	
	@Query("SELECT w FROM WorkSheetEntity w WHERE w.employeeId = :employeeId")
	List<WorkSheetEntity> findByEmployeeId(@Param("employeeId") Long employeeId);

}
