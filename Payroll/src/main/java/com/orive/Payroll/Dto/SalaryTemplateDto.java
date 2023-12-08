package com.orive.Payroll.Dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryTemplateDto {

	private Long salaryTemplateId;
	private double basicSalery;
	private double houseRentAllowance;
	private double medicalAllowance;
	private double pfAllowance;
	private double taxDeductiion;
	private double travellingAllowance;
	private double dearnessAllowance;
	private double grossSalery;
	private double totalDeduction;
	private double netSalery;
	private String payrollTemplate;	
	private LocalDate createdDate;
}
