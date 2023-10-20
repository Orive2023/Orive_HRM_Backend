package com.orive.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.project.Entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
