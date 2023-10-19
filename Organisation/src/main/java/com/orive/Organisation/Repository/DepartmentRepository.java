package com.orive.Organisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Organisation.Entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{

}
