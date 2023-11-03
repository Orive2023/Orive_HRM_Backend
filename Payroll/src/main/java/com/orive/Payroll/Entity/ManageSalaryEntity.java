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
@Table(name = "managesalary")
public class ManageSalaryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long manageSalaryId;
	
	@Column(name = "employee_full_name")
	private String employeeFullName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "date_of_joining")
	private String dateOfJoining;
	
	@Column(name = "employment_status")
	private String employmentStatus;
	
	@Column(name = "basic_salary")
	private double basicSalary;
	
	@Column(name = "salary_structure")
	private double salaryStructure;
	
	@Column(name = "pay_frequency")
	private String payFrequency;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "employee_job_grade")
	private String employeeJobGrade;
	
	@Column(name = "pay_scale")
	private String payScale;
	
	@Column(name = "housing_allowance")
	private double housingAllowance;
	
	@Column(name = "transportation_allowance")
	private double transportationAllowance;
	
	@Column(name = "medical_benefits")
	private String medicalBenefits;
	
	@Column(name = "other_allowances")
	private String otherAllowances;
	
	@Column(name = "tax_deductions")
	private String taxDeductions;
	
	@Column(name = "bank_account_number")
	private String bankAccountNumber;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "routing_number")
	private String routingNumber;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "previous_salary")
	private double previousSalary;
	
	@Column(name = "salary_increases")
	private String salaryIncreases;
	
	@Column(name = "performance_ratings")
	private int performanceRatings;
	
	@Column(name = "performance_bonuses")
	private String performanceBonuses;
}
