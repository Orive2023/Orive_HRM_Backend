package com.orive.Training.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Training.Entity.TrainingTypeEntity;

public interface TrainingTypeRepository extends JpaRepository<TrainingTypeEntity, Long> {

}
