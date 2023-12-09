package com.orive.Employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orive.Employee.Entity.EmployeesEntity;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Long>{
	
	
 List<EmployeesEntity> findEmployeeByEmployeeName(String employeeName);
 
 //Query for count male employee
 @Query("SELECT COUNT(e) FROM EmployeesEntity e WHERE e.gender = 'MALE'")
 Long countEmployeeByMale();
 
 //Query for count female employee
 @Query("SELECT COUNT(f) FROM EmployeesEntity f WHERE f.gender = 'FEMALE'")
 Long countEmployeeByFemale();
}
