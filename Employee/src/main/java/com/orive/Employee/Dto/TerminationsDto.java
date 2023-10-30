package com.orive.Employee.Dto;

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
public class TerminationsDto {
	
    private Long terminationId;
	private String employeeName;
	private String employeeIdNo;
	private String departmentName;
	private String employeeJobTitle;
	private String dateOfHire;
	private String lastWorkingDay;
	private String reasonForTermination;
	private String dateOfTermination;
	private String timeOfTermination;
	private String locationOfTermination;
	private double finalSalaryAmount;
	private String numberOfUnusedVacation;
	private String benefitsInformation;
	private double severancePayAmount;
	private String returnOfCompanyProperty;
	private String returnDeadline;
	private String employeesFeedback;
	private String employeesReasons;
	private String employeesSuggestions;
	private String employeesAcknowledgement;
	private String referencePolicyDetails;
	private String hrContactName;
	private String hrContactNumber;
	private String hrEmailId;
	private String employeesSignature;
	private String dateOfSigning;
	private String hrRepresentativesSignature;
	private String DateOfHrRepresentativesSignature;

}
