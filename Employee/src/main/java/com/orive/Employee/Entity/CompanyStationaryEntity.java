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
@Table(name = "company_stationary")
public class CompanyStationaryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CompanyStationaryId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "model_number")
	private Long modelNumber;
	
	@Column(name = "model_name")
	private String modelName;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_role")
	private String employeeRole;
	
	@Column(name = "assign_date")
	private LocalDate assignDate;
	
	@Column(name = "return_date")
	private LocalDate returnDate;
	
	@Column(name = "item_cost")
	private double itemCost;
}
