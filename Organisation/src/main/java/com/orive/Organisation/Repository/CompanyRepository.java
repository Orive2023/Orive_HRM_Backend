package com.orive.Organisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Organisation.Entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{

}
