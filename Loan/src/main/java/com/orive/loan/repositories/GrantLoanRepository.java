package com.orive.loan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.loan.entities.GrantLoanEntity;

public interface GrantLoanRepository extends JpaRepository<GrantLoanEntity, Long> {

}
