package com.orive.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Payroll.Entity.ManageSalaryEntity;

public interface ManageSalaryRepository extends JpaRepository<ManageSalaryEntity, Long> {

}
