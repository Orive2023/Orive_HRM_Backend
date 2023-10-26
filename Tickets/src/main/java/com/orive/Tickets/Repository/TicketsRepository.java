package com.orive.Tickets.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Tickets.Entity.TicketsEntity;

public interface TicketsRepository extends JpaRepository<TicketsEntity, Long> {

}
