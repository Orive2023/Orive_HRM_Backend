package com.orive.WorkSheet.Entity;

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
@Table(name = "work_sheet")
public class WorkSheetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workSheetId;
	
	@Column(name = "woek_sheet_title")
	private String workSheetTitle;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "estimate_hour")
	private double estimateHour;
	
	@Column(name = "project")
	private String project;
	
	@Column(name = "assigned_to")
	private String assignedTo;
	
	@Column(name = "description")
	private String description;
}
