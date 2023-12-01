package com.orive.WorkSheet.Entity;

import java.util.Date;

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
	
	@Column(name = "work_sheet_title")
	private String workSheetTitle;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "estimate_hour")
	private double estimateHour;
	
	@Column(name = "project")
	private String project;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "assigned_to")
	private String assignedTo;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "challange_part")
	private String challangePart;
	
	@Column(name = "work_progress")
	private String workProgress;
	
	@Column(name = "created_date")
	private Date createdDate;
}
