package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.AwardsEntity;

public interface AwardsRepository extends JpaRepository<AwardsEntity, Long>{

}
