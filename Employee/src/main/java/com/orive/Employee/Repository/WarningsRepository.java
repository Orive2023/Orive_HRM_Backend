package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.WarningsEntity;

public interface WarningsRepository extends JpaRepository<WarningsEntity, Long> {

}
