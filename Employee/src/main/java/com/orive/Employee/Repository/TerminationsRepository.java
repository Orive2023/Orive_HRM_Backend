package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.TerminationsEntity;

public interface TerminationsRepository extends JpaRepository<TerminationsEntity, Long> {

}
