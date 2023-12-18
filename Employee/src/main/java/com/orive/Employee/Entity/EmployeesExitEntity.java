package com.orive.Employee.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees_exit")
public class EmployeesExitEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long employeeExitId;
	
	@Column(name = "employee_to_exit")
	private String employeeToExit;
	
	@Column(name = "exit_date")
	private LocalDate exitDate;
	
	@Column(name = "type_of_exit")
	private String typeOfExit;
	
	@Column(name = "exit_interview")
	private String exitInterview;
	
	@Column(name = "inactivate_employee_account")
	private String inactivateEmployeeAccount;
	
	@Column(name = "description")
	private String description;
}
