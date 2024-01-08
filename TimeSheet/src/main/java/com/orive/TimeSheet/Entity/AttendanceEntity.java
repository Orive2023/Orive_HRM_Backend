package com.orive.TimeSheet.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "attendance")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "clock_in")
	private String clockIn;
	
	@Column(name = "clock_out")
	private String clockOut;
	
	@Column(name = "late")
	private Long late;
	
	@Column(name = "early_leaving")
	private Long earlyLeaving;
	
	@Column(name = "over_time")
	private Long overTime;
	
	@Column(name = "total_work")
	private Long totalWork;
	
	@Column(name ="total_rest" )
	private Long totalRest;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "clock_in_location")
	private String clockInLocation;
	
	@Column(name = "clock_out_location")
	private String clockOutLocation;
	
//	@Lob
//	@Column(name = "upload_doc",  length = 100000)
//	private byte[] uploadDoc;
}
