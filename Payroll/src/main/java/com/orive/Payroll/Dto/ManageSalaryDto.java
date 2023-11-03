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
public class ManageSalaryDto {
	
    private Long manageSalaryId;
	private String employeeFullName;
	private Long employeeId;
	private String department;
	private String jobTitle;
	private String dateOfJoining;
	private String employmentStatus;
	private double basicSalary;
	private double salaryStructure;
	private String payFrequency;
	private String currency;
	private String employeeJobGrade;
	private String payScale;
	private double housingAllowance;
	private double transportationAllowance;
	private String medicalBenefits;
	private String otherAllowances;
	private String taxDeductions;
	private String bankAccountNumber;
	private String bankName;
	private String routingNumber;
	private String paymentMethod;
	private double previousSalary;
	private String salaryIncreases;
	private int performanceRatings;
	private String performanceBonuses;
}
