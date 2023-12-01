package com.orive.TimeSheet.Entity;

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
	
	@Column(name = "clock_in")
	private String clockIn;
	
	@Column(name = "clock_out")
	private String clockOut;
	
	@Column(name = "late")
	private int late;
	
	@Column(name = "early_leaving")
	private int earlyLeaving;
	
	@Column(name = "over_time")
	private int overTime;
	
	@Column(name = "total_work")
	private int totalWork;
	
	@Column(name ="total_rest" )
	private int totalRest;
	
	@Column(name = "date")
	private String date;
	
	@Lob
	@Column(name = "upload_doc",  length = 100000)
	private byte[] uploadDoc;
}
