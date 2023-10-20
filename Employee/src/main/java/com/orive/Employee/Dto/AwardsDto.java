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
public class AwardsDto {

    private Long awardId;
	private String employeeName;
	private String awardName;
	private String gift;
	private Long cashPrice;
	private String awardDate;
}
