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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "generatepayslip")
public class GeneratePayslipEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long generatePayslipId;
	
	@Column(name = "employee_full_name")
	private String employeeFullName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "pay_period")
	private String payPeriod;
	
	@Column(name = "basic_salary")
	private double basicSalary;

	@Column(name = "overtime_pay")
	private double overtimePay;

	@Column(name = "bonuses")
	private double bonuses;
	
	@Column(name = "gross_earnings")
	private double grossEarnings;
	
	@Column(name = "tax_deductions")
	private double taxDeductions;
	
	@Column(name = "social_security_contributions")
	private double socialSecurityContributions;
	
	@Column(name = "pension_contributions")
	private double pensionContributions;
	
	@Column(name = "health_insurance")
	private double healthInsurance;
	
	@Column(name = "other_deductions")
	private double otherDeductions;
	
	@Column(name = "total_deductions")
	private double totalDeductions;
	
	@Column(name = "net_salary")
	private double netSalary;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_address")
	private String companyAddress;
	
	@Column(name = "employer_tax_id")
	private String employerTaxId;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "tax_year")
	private String taxYear;
	
	@Column(name = "taxable_income")
	private String taxableIncome;
	
	@Column(name = "tax_rate")
	private String taxRate;
	
	@Column(name = "total_taxes")
	private String totalTaxes;
	
	@Column(name = "leave_balances")
	private String leaveBalances;
}
