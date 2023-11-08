package com.orive.Accounts.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "opening_balance")
public class OpeningBalanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long openingBalanceId;
	
	@Column(name = "financial_year")
	private String financialYear;
	
	@Column(name = "date")
	private String date;
	
	@OneToMany(targetEntity = OpeningBalanceTableEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "opening_balance_table_fk",referencedColumnName = "openingBalanceId")
	private List<OpeningBalanceTableEntity> openingBalanceTableEntities;
	
	@Column(name = "debit_total")
	private double debitTotal;
	
	@Column(name = "credit_total")
	private double creditTotal;
}
