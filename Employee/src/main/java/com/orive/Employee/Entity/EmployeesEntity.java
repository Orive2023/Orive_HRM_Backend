package com.orive.Employee.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class EmployeesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "maiden_name")
	private String maidenName;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "phone")
	private Long phone;
	
	@Column(name = "alternative_phone")
	private Long alternativePhone;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "attendance_time")
	private String attendanceTime;
	
	@Column(name = "employee_type")
	private String employeeType;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "ifsc_number")
	private Long ifscNumber;
	
	@Column(name = "branch_address")
	private String branchAddress;
	
	@Column(name = "basic_salary")
	private double basicSalary;
	
	@Column(name = "transportation_allowance")
	private double transportationAllowance;
	
	@Column(name = "gross_salary")
	private double grossSalary;
	
	@Column(name = "tax_number")
	private String taxNumber;
	
	@Column(name = "sub_department")
	private String subDepartment;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "duty_type")
	private String dutyType;
	
	@Column(name = "hire_date")
	private String hireDate;
	
	@Column(name = "joining_date")
	private String joiningDate;
	
	@Column(name = "tremination_date")
	private String treminationDate;
	
	@Column(name = "tremination_reason")
	private String treminationReason;
	
	@Column(name = "voluntary_termination")
	private String voluntaryTermination;
	
	@Column(name = "re_hire_date")
	private String reHireDate;
	
	@Column(name = "rate_type")
	private String rateType;
	
	@Column(name = "rate")
	private Long rate;
	
	@Column(name = "monthly_work_hours")
	private String monthlyWorkHours;
	
	@Column(name = "pay_frequency")
	private String payFrequency;
	
	@Column(name = "pay_frequency_text")
	private String payFrequencyText;
	
	@Column(name = "hourly_rate2")
	private String hourlyRate2;
	
	@Column(name = "hourly_rate3")
	private String hourlyRate3;
	
	@Column(name = "home_department")
	private String homeDepartment;
	
	@Column(name = "department_text")
	private String departmentText;
	
	@Column(name = "medical")
	private String medical;
	
	@Column(name = "family")
	private String family;
	
	@Column(name = "transportation")
	private String transportation;
	
	@Column(name = "others")
	private String others;
	
	@Column(name = "class_code")
	private String classCode;
	
	@Column(name = "class_description")
	private String classDescription;
	
	@Column(name = "class_accrual_date")
	private String classAccrualDate;
	
	@Column(name = "class_status")
	private String classStatus;
	
	@Column(name = "supervisor_name")
	private String supervisorName;
	
	@Column(name = "first_supervisor")
	private String firstSupervisor;
	
	@Column(name = "reporting_to")
	private String reportingTo;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "marital_status")
	private String maritalStatus;
	
	@Column(name = "ethnic_group")
	private String ethnicGroup;
	
	@Column(name = "sos")
	private String sos;
	
	@Column(name = "work_in_city")
	private String workInCity;
	
	@Column(name = "city_of_residence")
	private String cityOfResidence;
	
	@Column(name = "work_permit")
	private String workPermit;
	
	@Column(name = "photograph")
	private String photograph;
	
	@Column(name = "home_email")
	private String homeEmail;
	
	@Column(name = "business_email")
	private String businessEmail;
	
	@Column(name = "home_phone")
	private Long homePhone;
	
	@Column(name = "business_phone")
	private Long businessPhone;
	
	@Column(name = "cell_phone")
	private Long cellPhone;
	
	@Column(name = "emergency_contact_person")
	private String emergencyContactPerson;
	
	@Column(name = "emergency_contact_relationship")
	private String emergencyContactRelationship;
	
	@Column(name = "emergency_contact")
	private String emergencyContact;
	
	@Column(name = "alter_emergency_contact")
	private String alterEmergencyContact;
	
	@Column(name = "emergency_home_phone")
	private Long emergencyHomePhone;
	
	@Column(name = "alt_emergency_home_phone")
	private Long altEmergencyHomePhone;
	
	@Column(name = "emergency_work_phone")
	private Long emergencyWorkPhone;
	
	@Column(name = "alt_emergency_work_phone")
	private Long altEmergencyWorkPhone;
	
	@Column(name = "custom_field_name")
	private String customFieldName;
	
	@Column(name = "custom_field_type")
	private String customFieldType;
	
	@Column(name = "custom_value")
	private String customValue;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "password")
	private String password;
}
