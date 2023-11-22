package com.orive.Organisation.Dto;


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
public class DepartmentDto {

    private Long departmentId;
	private String departmentName;
	private String companyName;
	private String locationName;
	private String departmentHead;
	private String status;
	private String approvedBy;
}
