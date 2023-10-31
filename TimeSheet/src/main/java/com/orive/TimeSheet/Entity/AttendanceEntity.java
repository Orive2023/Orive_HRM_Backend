package com.orive.TimeSheet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "attendance")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "reporting_period_start_date")
	private String reportingPeriodStartDate;
	
	@Column(name = "reporting_period_end_date")
	private String reportingPeriodEndDate;
	
	@Column(name = "daily_attendance_date")
	private String dailyAttendanceDate;
	
	@Column(name ="daily_attendance_in_time" )
	private String dailyAttendanceInTime;
	
	@Column(name = "daily_attendance_out_time")
	private String dailyAttendanceOutTime;
	
	@Column(name = "daily_attendance_breaks")
	private String dailyAttendanceBreaks;
	
	@Column(name = "daily_attendance_total_hours")
	private String dailyAttendanceTotalHours;
	
	@Column(name = "total_hours_for_reporting_period")
	private String totalHoursForReportingPeriod;
	
	@Column(name = "leave_type")
	private String leaveType;
	
	@Column(name = "leave_start_date")
	private String leaveStartDate;
	
	@Column(name = "leave_end_date")
	private String leaveEndDate;
	
	@Column(name = "leave_reason")
	private String leaveReason;
	
	@Column(name = "managers_approval")
	private String managersApproval;
	
	@Column(name = "managers_comments")
	private String managersComments;
}
