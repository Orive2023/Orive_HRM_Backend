package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.ResignationsEntity;

public interface ResignationsRepository extends JpaRepository<ResignationsEntity, Long> {

}
