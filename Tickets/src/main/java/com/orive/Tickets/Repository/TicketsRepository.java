package com.orive.Tickets.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.orive.Tickets.Entity.TicketsEntity;


public interface TicketsRepository extends JpaRepository<TicketsEntity, Long> {
	
//	@Query("SELECT t FROM TicketsEntity t WHERE t.employeeId = :employeeId")
//	Optional<TicketsEntity> findByEmployeeId(@Param("employeeId") Long employeeId);


	
	@Query("SELECT t FROM TicketsEntity t WHERE t.employeeId = :employeeId")
	List<TicketsEntity> findByEmployeeId(@Param("employeeId") Long employeeId);
}
