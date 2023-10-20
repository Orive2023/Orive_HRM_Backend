package com.orive.TimeSheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.TimeSheet.Entity.HolidaysEntity;

public interface HolidaysRepository extends JpaRepository<HolidaysEntity, Long>{

}
