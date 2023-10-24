package com.orive.Payroll.Dto;

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
public class PayrollTemplateDto {

	private Long PayRollTemplateId;
	private String templateName;
	private double basicSalery;
	private double overTimeRate;
	private double houseRentAllowance;
	private double medicalAllowance;
	private double taxDeductiion;
	private double travellingAllowance;
	private double dearnessAllowance;
	private double securityDeposit;
	private double grossSalery;
	private double totalAllowance;
	private double totalDeduction;
	private double netSalery;
}
