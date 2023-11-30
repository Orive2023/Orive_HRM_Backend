package com.orive.TimeSheet.Entity;

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
@Table(name = "leaves")
public class LeavesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveId;
	
	@Column(name = "leave_type")
	private String leaveType;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "leave_reason")
	private String leaveReason;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name = "applied_on")
	private String appliedOn;
}
