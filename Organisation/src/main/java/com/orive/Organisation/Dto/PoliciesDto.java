package com.orive.Organisation.Dto;

import java.util.List;

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
public class PoliciesDto {

	
	private Long policiesId;
	private String companyName;
	private String title;
	private String description;
	private String status;
	private boolean approvedBy;
}
