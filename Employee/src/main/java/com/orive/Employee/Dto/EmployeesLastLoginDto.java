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
public class EmployeesLastLoginDto {
	
    private Long employeeLastLoginId;
	private String employeeName;
	private String employeeUserName;
	private String lastLoginDate;
	private String lastLoginTime;
	private String role;
	private String status;

}
