package com.orive.Payroll.Dto;

import java.util.Date;

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
public class AdvanceSaleryDto {

	private Long advanceSaleryId;
	private String createdDate;
	private String employeeName;
	private String salary;
	private double advanceAmount;
	private String salaryDue;
	private Date monthAndYear;
}
