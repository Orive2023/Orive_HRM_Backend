package com.orive.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Payroll.Entity.GeneratePayslipEntity;

public interface GeneratePayslipRepository extends JpaRepository<GeneratePayslipEntity, Long> {

}
