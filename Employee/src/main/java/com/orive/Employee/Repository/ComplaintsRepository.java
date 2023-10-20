package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.ComplaintsEntity;

public interface ComplaintsRepository extends JpaRepository<ComplaintsEntity, Long> {

}
