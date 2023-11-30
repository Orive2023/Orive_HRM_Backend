package com.orive.Organisation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Organisation.Entity.CompanyEntity;
import com.orive.Organisation.Entity.PoliciesEntity;

public interface PoliciesRepository extends JpaRepository<PoliciesEntity, Long>{

}
