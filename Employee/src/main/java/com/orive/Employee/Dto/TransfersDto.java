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
public class TransfersDto {

	private Long transferId;
	private String employeeName;
	private String transferDate;
	private String TransferToDepartment;
	private String transferToLocation;
}
