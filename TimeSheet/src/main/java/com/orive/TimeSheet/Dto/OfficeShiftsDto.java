package com.orive.TimeSheet.Dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OfficeShiftsDto {

	private Long officeShiftsId;
	private LocalDate createdDate;
	private String day;
	private String mondayInTime;
	private String mondayOutTime;
	private String tuesdayInTime;
	private String tuesdayOutTime;
	private String wednesdayInTime;
	private String wednesdayOutTime;
	private String thursdayInTime;
	private String thursdayOutTime;
	private String fridayInTime;
	private String fridayOutTime;
	private String saturdayInTime;
	private String saturdayOutTime;
	private String sundayInTime;
	private String sundayOutTime;
}
