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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintsDto {
		
    private Long complaintsId;
	private String complaintFrom;
	private String complaintTitle;
	private Date complaintDate;
	private String complaintAgainst;
	private String description;

}
