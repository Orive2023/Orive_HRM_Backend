package com.orive.project.Entity;

import java.time.LocalDate;

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
@Table(name = "employeeProjectManagement")
public class EmployeeProjectManagementEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeProjectManagementId;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "task_assigned_for")
	private String taskAssignedFor;
	
//	@Lob
//	@Column(name = "type_the_task_here", length = 100000)
//	private byte[] typeTheTaskHere;
	

	@Column(name = "type_the_task_here")
	private String typeTheTaskHere;
}
