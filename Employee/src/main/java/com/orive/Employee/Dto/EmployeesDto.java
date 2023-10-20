package com.orive.Employee.Dto;

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
	private String employeeName;
	private String gender;
	private String address;
	private String dateOfBirth;
}
