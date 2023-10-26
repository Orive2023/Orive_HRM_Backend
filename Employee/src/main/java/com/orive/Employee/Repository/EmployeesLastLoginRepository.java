package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.EmployeesLastLoginEntity;

public interface EmployeesLastLoginRepository extends JpaRepository<EmployeesLastLoginEntity, Long> {

}
