package com.orive.Employee.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "employees")
public class EmployeesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "designation_name")
	private String designationName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private Long phone;
	
	@Column(name = "alternative_phone")
	private Long alternativePhone;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip_code")
	private int zipCode;
	
	@Column(name = "employee_role")
	private String employeeRole;
	
	@Column(name = "company_type")
	private String companyType;
	
	@Column(name = "attendance_time")
	private String attendanceTime;
	
	@Column(name = "employee_type")
	private String employeeType;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
		
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "ifsc_number")
	private String ifscNumber;
	
	@Column(name = "branch_name")
	private String branchName;
	
	@Column(name = "basic_salary")
	private double basicSalary;
	
	@Column(name = "transport_allowance")
	private double transportAllowance;
	
	@Column(name = "gross_salary")
	private double grossSalary;
	
	@Column(name = "tin_number")
	private Long tinNumber;
	
	@Column(name = "hra_allowances")
	private double hraAllowances;
	
	@Column(name = "other_allowances")
	private double otherAllowances;
	
	@Column(name = "pf_allowances")
	private double pfAllowances;
	
	@Column(name = "da_allowances")
	private double daAllowances;
	
	@Column(name = "medical_allowances")
	private double medicalAllowances;
	
	@Column(name = "other_insurance")
	private double otherInsurance;
	
	@Column(name = "tax")
	private double tax;
	
	@Column(name = "sub_department")
	private String subDepartment;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "duty_type")
	private String dutyType;
	
	@Column(name = "hire_date")
	private LocalDate hireDate;
	
	@Column(name = "joining_date")
	private LocalDate joiningDate;
	
	@Column(name = "rate_type")
	private String rateType;
	
	@Column(name = "rate_number")
	private int rateNumber;
	
	@Column(name = "monthly_work_hours")
	private int monthlyWorkHours;
	
	@Column(name = "pay_frequency")
	private String payFrequency;
	
	@Column(name = "medical")
	private String medical;
	
	@Column(name = "family")
	private String family;
	
	@Column(name = "transportation")
	private String transportation;
	
	@Column(name = "others")
	private String others;
	
	@Column(name = "team_leader_name")
	private String teamLeaderName;
	
	@Column(name = "reporting_to")
	private String reportingTo;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "marital_status")
	private String maritalStatus;
	
	@Column(name = "work_in_city")
	private String workInCity;
	
	@Column(name = "city_of_residence")
	private String cityOfResidence;
	
	@Column(name = "work_permit")
	private String workPermit;
	
	@Lob
	@Column(name = "upload_photo", length = 100000)
	private byte[] uploadPhoto;
	
	@Column(name = "business_email")
	private String businessEmail;
	
	@Column(name = "home_phone")
	private Long homePhone;
	
	@Column(name = "cell_phone")
	private Long cellPhone;
	
	@Column(name = "user_email_or_name")
	private String userEmailOrName;
	
	@Column(name = "password")
	private String password;
	
	@Lob
	@Column(name = "upload_document", length = 100000)
	private byte[] uploadDocument;
}
