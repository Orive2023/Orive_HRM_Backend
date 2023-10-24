package com.orive.Payroll.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HourlyWagesDto {

    private Long hourlyWagesId;
	private String hourlyWageTitle;
	private double hourlyRate;
}
