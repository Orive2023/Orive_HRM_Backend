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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "pay_roll_template")
public class PayRollTemplateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PayRollTemplateId;
	
	@Column(name = "template_name")
	private String templateName;
	
	@Column(name = "basic_salery")
	private double basicSalery;
	
	@Column(name = "over_time_rate")
	private double overTimeRate;
	
	@Column(name = "house_rent_allowance")
	private double houseRentAllowance;
	
	@Column(name = "medical_allowance")
	private double medicalAllowance;
	
	@Column(name = "tax_deductiion")
	private double taxDeductiion;
	
	@Column(name = "travelling_allowance")
	private double travellingAllowance;
	
	@Column(name = "dearness_allowance")
	private double dearnessAllowance;
	
	@Column(name = "security_deposit")
	private double securityDeposit;
	
	@Column(name = "gross_salery")
	private double grossSalery;
	
	@Column(name = "total_allowance")
	private double totalAllowance;
	
	@Column(name = "total_deduction")
	private double totalDeduction;
	
	@Column(name = "net_salery")
	private double netSalery;
}
