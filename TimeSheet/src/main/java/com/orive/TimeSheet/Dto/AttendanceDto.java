package com.orive.TimeSheet.Dto;

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
public class AttendanceDto {
	
	private Long attendanceId;
	private String employeeName;
	private String clockIn;
	private String clockOut;
	private int late;
	private int earlyLeaving;
	private int overTime;
	private int totalWork;
	private int totalRest;
	private Date date;

}
