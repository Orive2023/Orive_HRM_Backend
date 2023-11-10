package com.orive.Employee.Entity;

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
@Table(name = "termination")
public class TerminationsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long terminationId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id_no")
	private String employeeIdNo;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "employee_job_title")
	private String employeeJobTitle;
	
	@Column(name = "date_of_hire")
	private String dateOfHire;
	
	@Column(name = "last_working_day")
	private String lastWorkingDay;
	
	@Column(name = "reason_for_termination")
	private String reasonForTermination;
	
	@Column(name = "date_of_termination")
	private String dateOfTermination;
	
	@Column(name = "time_of_termination")
	private String timeOfTermination;
	
	@Column(name = "location_of_termination")
	private String locationOfTermination;
	
	@Column(name = "final_salary_amount")
	private double finalSalaryAmount;
	
	@Column(name = "number_of_unused_vacation")
	private String numberOfUnusedVacation;
	
	@Column(name = "benefits_information")
	private String benefitsInformation;
	
	@Column(name = "severance_pay_amount")
	private double severancePayAmount;
	
	@Column(name = "return_of_company_property")
	private String returnOfCompanyProperty;
	
	@Column(name = "return_deadline")
	private String returnDeadline;
	
	@Column(name = "employees_feedback")
	private String employeesFeedback;
	
	@Column(name = "employees_reasons")
	private String employeesReasons;
	
	@Column(name = "employees_suggestions")
	private String employeesSuggestions;
	
	@Column(name = "employees_acknowledgement")
	private String employeesAcknowledgement;
	
	@Column(name = "reference_policy_details")
	private String referencePolicyDetails;
	
	@Column(name = "hr_contact_name")
	private String hrContactName;
	
	@Column(name = "hr_contact_number")
	private String hrContactNumber;
	
	@Column(name = "hr_email_id")
	private String hrEmailId;
	
	@Column(name = "employees_signature")
	private String employeesSignature;
	
	@Column(name = "date_of_signing")
	private String dateOfSigning;
	
	@Column(name = "hr_representatives_signature")
	private String hrRepresentativesSignature;
	
	@Column(name = "Date_of_hr_representatives_signature")
	private String DateOfHrRepresentativesSignature;
}
