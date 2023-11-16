package com.orive.Organisation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.orive.Organisation.Entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{

	Optional<CompanyEntity> findByCompanyName(String companyName);
}
