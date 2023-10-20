package com.orive.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Employee.Entity.TravelsEntity;

public interface TravelsRepository extends JpaRepository<TravelsEntity, Long>{

}
