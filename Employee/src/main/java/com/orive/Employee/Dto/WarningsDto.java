package com.orive.Employee.Dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
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
public class WarningsDto {
	
	private Long warningsId;
	private String warningToEmployee;
	private String warningType;
	private String subject;
	private String warningByEmployee;
	private LocalDate warningDate;
	private String description;

}
