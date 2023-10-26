package com.orive.WorkSheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.WorkSheet.Entity.WorkSheetEntity;

public interface WorkSheetRepository extends JpaRepository<WorkSheetEntity, Long>{

}
