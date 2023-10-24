package com.orive.Payroll.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advance_salery")
public class AdvanceSaleryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long advanceSaleryId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "month_and_year")
	private String monthAndYear;
	
	@Column(name = "one_time_deduct")
	private String oneTimeDeduct;
	
	@Column(name = "emi")
	private String emi;
}
