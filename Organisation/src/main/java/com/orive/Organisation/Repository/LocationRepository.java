package com.orive.Organisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Organisation.Entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Long>{

}
