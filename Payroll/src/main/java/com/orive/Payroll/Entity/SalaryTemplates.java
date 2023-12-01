package com.orive.Payroll.Entity;

import java.util.Date;

import jakarta.persistence.Column;
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
@Table(name = "salary_templates")
public class SalaryTemplates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salaryTemplatesId;
	
	@Column(name = "basic_salary")
	private double basicSalary;
	
	@Column(name = "house_rent_allowance")
	private double houseRentAllowance;
	
	@Column(name = "medical_allowance")
	private double medicalAllowance;
	
	@Column(name = "pf")
	private double pf;
	
	@Column(name = "tax_deduction")
	private double taxDeduction;
	
	@Column(name = "transport_allowance")
	private double transportAllowance;
	
	@Column(name = "dearness_allowance")
	private double dearnessAllowance;
	
	@Column(name = "gross_salary")
	private double grossSalary;
	
	@Column(name = "total_deduction")
	private double totalDeduction;
	
	@Column(name = "net_salary")
	private double netSalary;
	
	@Column(name = "payroll_template")
	private String payrollTemplate;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	
}
