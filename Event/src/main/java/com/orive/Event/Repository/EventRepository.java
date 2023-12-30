package com.orive.Event.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Event.Entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long>{

}
