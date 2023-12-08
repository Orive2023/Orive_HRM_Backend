package com.orive.Payroll.Entity;

import java.time.LocalDate;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "salary_template")
public class SalaryTemplateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salaryTemplateId;
		
	@Column(name = "basic_salery")
	private double basicSalery;
	
	@Column(name = "house_rent_allowance")
	private double houseRentAllowance;
	
	@Column(name = "medical_allowance")
	private double medicalAllowance;
	
	@Column(name = "pf_allowance")
	private double pfAllowance;
	
	@Column(name = "tax_deductiion")
	private double taxDeductiion;

	@Column(name = "travelling_allowance")
	private double travellingAllowance;
	
	@Column(name = "dearness_allowance")
	private double dearnessAllowance;

	@Column(name = "gross_salery")
	private double grossSalery;
	
	@Column(name = "total_deduction")
	private double totalDeduction;
	
	@Column(name = "net_salery")
	private double netSalery;
	
	@Column(name = "payroll_template")
	private String payrollTemplate;	
	
	@Column(name = "created_date")
	private LocalDate createdDate;
}
