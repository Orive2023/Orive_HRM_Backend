package com.orive.TimeSheet.Dto;

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
	private String employeeId;
	private String department;
	private String jobTitle;
	private String reportingPeriodStartDate;
	private String reportingPeriodEndDate;
	private String dailyAttendanceDate;
	private String dailyAttendanceInTime;
	private String dailyAttendanceOutTime;
	private String dailyAttendanceBreaks;
	private String dailyAttendanceTotalHours;
	private String totalHoursForReportingPeriod;
	private String leaveType;
	private String leaveStartDate;
	private String leaveEndDate;
	private String leaveReason;
	private String managersApproval;
	private String managersComments;

}
