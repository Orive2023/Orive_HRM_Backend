package com.orive.Performance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Performance.Entity.PerformanceIndicatorEntity;

public interface PerformanceIndicatorRepository extends JpaRepository<PerformanceIndicatorEntity, Long> {

}
