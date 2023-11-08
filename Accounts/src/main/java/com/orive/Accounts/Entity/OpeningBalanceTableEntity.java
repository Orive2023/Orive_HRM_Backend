package com.orive.Accounts.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "opening_balance_table")
public class OpeningBalanceTableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long openingBalanceTableId;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "sub_type")
	private String subType;
	
	@Column(name = "debit")
	private double debit;
	
	@Column(name = "credit")
	private double credit;
	
	
}
