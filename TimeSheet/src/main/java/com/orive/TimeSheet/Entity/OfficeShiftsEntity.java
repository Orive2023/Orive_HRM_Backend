package com.orive.TimeSheet.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "office_shift")
public class OfficeShiftsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long officeShiftsId;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "monday_in_time")
	private String mondayInTime;
	
	@Column(name = "monday_out_time")
	private String mondayOutTime;
	
	@Column(name = "tuesday_in_time")
	private String tuesdayInTime;
	
	@Column(name = "tuesday_out_time")
	private String tuesdayOutTime;
	
	@Column(name = "wednesday_in_time")
	private String wednesdayInTime;
	
	@Column(name = "wednesday_out_time")
	private String wednesdayOutTime;
	
	@Column(name = "thursday_in_time")
	private String thursdayInTime;
	
	@Column(name = "thursday_out_time")
	private String thursdayOutTime;
	
	@Column(name = "friday_in_time")
	private String fridayInTime;
	
	@Column(name = "friday_out_time")
	private String fridayOutTime;
	
	@Column(name = "saturday_in_time")
	private String saturdayInTime;
	
	@Column(name = "saturday_out_time")
	private String saturdayOutTime;
	
	@Column(name = "sunday_in_time")
	private String sundayInTime;
	
	@Column(name = "sunday_out_time")
	private String sundayOutTime;
}
