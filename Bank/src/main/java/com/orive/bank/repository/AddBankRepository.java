package com.orive.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.bank.entities.AddBankEntity;

public interface AddBankRepository extends JpaRepository<AddBankEntity, Long>{

}
