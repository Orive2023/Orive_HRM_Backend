package com.orive.Employee.Dto;

import jakarta.persistence.Column;
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
public class EmployeesDto {

    private Long employeeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String maidenName;
	private String emailAddress;
	private Long phone;
	private Long alternativePhone;
	private String country;
	private String city;
	private String zipCode;
	private String attendanceTime;
	private String employeeType;
	private Long accountNumber;
	private String bankName;
	private Long ifscNumber;
	private String branchAddress;
	private double basicSalary;
	private double transportationAllowance;
	private double grossSalary;
	private String taxNumber;
	private String subDepartment;
	private String position;
	private String dutyType;
	private String hireDate;
	private String joiningDate;
	private String treminationDate;
	private String treminationReason;
	private String voluntaryTermination;
	private String reHireDate;
	private String rateType;
	private Long rate;
	private String monthlyWorkHours;
	private String payFrequency;
	private String payFrequencyText;
	private String hourlyRate2;
	private String hourlyRate3;
	private String homeDepartment;
	private String departmentText;
	private String medical;
	private String family;
	private String transportation;
	private String others;
	private String classCode;
	private String classDescription;
	private String classAccrualDate;
	private String classStatus;
	private String supervisorName;
	private String firstSupervisor;
	private String reportingTo;
	private String dateOfBirth;
	private String gender;
	private String maritalStatus;
	private String ethnicGroup;
	private String sos;
	private String workInCity;
	private String cityOfResidence;
	private String workPermit;
	private String photograph;
	private String homeEmail;
	private String businessEmail;
	private Long homePhone;
	private Long businessPhone;
	private Long cellPhone;
	private String emergencyContactPerson;
	private String emergencyContactRelationship;
	private String emergencyContact;
	private String alterEmergencyContact;
	private Long emergencyHomePhone;
	private Long altEmergencyHomePhone;
	private Long emergencyWorkPhone;
	private Long altEmergencyWorkPhone;
	private String customFieldName;
	private String customFieldType;
	private String customValue;
	private String userEmail;
	private String password;
}
