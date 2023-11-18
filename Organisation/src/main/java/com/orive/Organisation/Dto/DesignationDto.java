package com.orive.Organisation.Dto;

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
public class DesignationDto {

    private Long designationId;
	private String departmentName;
	private String designationName;
	private String status;
	private boolean approvedBy;
}
