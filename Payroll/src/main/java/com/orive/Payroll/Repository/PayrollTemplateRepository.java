package com.orive.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Payroll.Entity.PayRollTemplateEntity;

public interface PayrollTemplateRepository extends JpaRepository<PayRollTemplateEntity, Long>{

}
