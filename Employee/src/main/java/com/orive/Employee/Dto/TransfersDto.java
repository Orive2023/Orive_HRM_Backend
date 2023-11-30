package com.orive.Employee.Dto;

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
public class TransfersDto {

    private Long transferId;
	private String employeeName;
	private Date transferDate;
	private String departmentName;
	private String locationName;
	private String description;
}
