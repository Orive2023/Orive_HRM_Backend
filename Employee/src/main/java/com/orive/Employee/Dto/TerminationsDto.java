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
public class TerminationsDto {
	
    private Long terminationId;
	private String employeeName;
	private Date terminateDate;
	private String reasonForTermination;
	private String terminatedBy;
}
