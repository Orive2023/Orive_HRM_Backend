package com.orive.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
	private String accountNumber;
	
	@Column(name = "branch_name")
	private String branchName;

}
