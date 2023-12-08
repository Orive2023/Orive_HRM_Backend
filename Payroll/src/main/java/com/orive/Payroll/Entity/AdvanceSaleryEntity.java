package com.orive.Payroll.Entity;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "advance_salery")
public class AdvanceSaleryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long advanceSaleryId;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "advance_amount")
	private double advanceAmount;
	
	@Column(name = "salary_due")
	private double salaryDue;
	
	@Column(name = "month_and_year")
	private LocalDate monthAndYear;
}
