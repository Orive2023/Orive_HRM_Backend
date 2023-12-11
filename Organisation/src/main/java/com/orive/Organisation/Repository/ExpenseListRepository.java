package com.orive.Organisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Organisation.Entity.ExpenseListEntity;

public interface ExpenseListRepository extends JpaRepository<ExpenseListEntity, Long>{

}
