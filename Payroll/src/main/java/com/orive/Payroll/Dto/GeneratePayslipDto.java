package com.orive.Payroll.Dto;

import jakarta.persistence.Column;
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
public class GeneratePayslipDto {
	
    private Long generatePayslipId;
	private String employeeFullName;
	private Long employeeId;
	private String department;
	private String jobTitle;
	private String payPeriod;
	private double basicSalary;
	private double overtimePay;
	private double bonuses;
	private double grossEarnings;
	private double taxDeductions;
	private double socialSecurityContributions;
	private double pensionContributions;
	private double healthInsurance;
	private double otherDeductions;
	private double totalDeductions;
	private double netSalary;
	private String companyName;
	private String companyAddress;
	private String employerTaxId;
	private String paymentMethod;
	private String taxYear;
	private String taxableIncome;
	private String taxRate;
	private String totalTaxes;
	private String leaveBalances;
}
