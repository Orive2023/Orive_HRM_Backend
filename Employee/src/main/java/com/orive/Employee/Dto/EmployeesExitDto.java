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
public class EmployeesExitDto {
	
	private Long employeeExitId;
	private String employeeToExit;
	private String exitDate;
	private String typeOfExit;
	private String exitInterview;
	private String inactivateEmployeeAccount;
	private String description;

}
