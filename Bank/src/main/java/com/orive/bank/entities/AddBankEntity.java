package com.orive.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "addbankentity")
public class AddBankEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addBankId;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "branch_name")
	private String branchName;
	
	@Column(name = "account_type")
	private String accountType;
}
