package com.orive.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.orive.project.Entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

	@Query("SELECT p FROM ProjectEntity p WHERE p.employeeId = :employeeId")
	List<ProjectEntity> findByEmployeeId(@Param("employeeId") Long employeeId);
}
