package com.orive.TimeSheet.Dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceDto {
 	
	private Long attendanceId;
	private String employeeName;
	private Long employeeId;
	private String clockIn;
	private String clockOut;
	private Long late;
	private Long earlyLeaving;
	private Long overTime;
	private Long totalWork;
	private Long totalRest;
	private LocalDate date;
	private String clockInLocation;
	private String clockOutLocation;
//	private byte[] uploadDoc;
}
