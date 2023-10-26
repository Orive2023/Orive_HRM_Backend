package com.orive.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Payroll.Entity.HourlyWagesEntity;

public interface HourlyWagesRepository extends JpaRepository<HourlyWagesEntity, Long> {

}
