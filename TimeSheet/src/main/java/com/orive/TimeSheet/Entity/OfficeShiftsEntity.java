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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "office_shift")
public class OfficeShiftsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long OfficeShiftsId;
	
	@Column(name = "shift_name")
	private String shiftName;
	
	@Column(name = "monday")
	private String monday;
	
	@Column(name = "tuesday")
	private String tuesday;
	
	@Column(name = "wednesday")
	private String wednesday;
	
	@Column(name = "thursday")
	private String thursday;
	
	@Column(name = "friday")
	private String friday;
	
	@Column(name = "saturday")
	private String saturday;
	
	@Column(name = "sunday")
	private String sunday;
}
