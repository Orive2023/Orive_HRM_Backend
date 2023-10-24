package com.orive.Payroll.Dto;

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
	private String employeeName;
	private double amount;
	private String monthAndYear;
	private String oneTimeDeduct;
	private String emi;
}
