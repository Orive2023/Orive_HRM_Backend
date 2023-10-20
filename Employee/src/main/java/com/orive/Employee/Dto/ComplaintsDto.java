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
public class ComplaintsDto {
		
	private Long complaintsId;
	private String complaintFromEmployee;
	private String complaintTitle;
	private String complaintDate;
	private String complaintAgainstEmployee;
	private String description;

}
