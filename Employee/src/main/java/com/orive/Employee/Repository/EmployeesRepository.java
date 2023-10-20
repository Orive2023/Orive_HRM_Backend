package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.EmployeesEntity;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Long>{

}
