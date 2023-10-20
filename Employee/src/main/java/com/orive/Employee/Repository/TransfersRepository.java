package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.TransfersEntity;

public interface TransfersRepository extends JpaRepository<TransfersEntity, Long>{

}
