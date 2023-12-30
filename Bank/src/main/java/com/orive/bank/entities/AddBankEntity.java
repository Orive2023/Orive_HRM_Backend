package com.orive.bank.entities;

import com.orive.bank.configuration.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
	@Convert(converter = AesEncryptor.class)
	private String bankName;
	
	@Column(name = "account_name")
	@Convert(converter = AesEncryptor.class)
	private String accountName;
	
	@Column(name = "account_number")
	@Convert(converter = AesEncryptor.class)
	private Long accountNumber;
	
	@Column(name = "branch_name")
	@Convert(converter = AesEncryptor.class)
	private String branchName;
	
	@Column(name = "account_type")
	@Convert(converter = AesEncryptor.class)
	private String accountType;
}
