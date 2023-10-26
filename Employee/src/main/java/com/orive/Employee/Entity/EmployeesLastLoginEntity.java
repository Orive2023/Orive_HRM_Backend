package com.orive.Employee.Entity;

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
@Table(name = "employee_last_login")
public class EmployeesLastLoginEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeLastLoginId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_user_name")
	private String employeeUserName;
	
	@Column(name = "last_login_date")
	private String lastLoginDate;
	
	@Column(name = "last_login_time")
	private String lastLoginTime;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "status")
	private String status;


}
