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
@Table(name = "warnings")
public class WarningsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long warningsId;
	
	@Column(name = "warning_to_employee")
	private String warningToEmployee;
	
	@Column(name = "warning_type")
	private String warningType;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "warning_by_employee")
	private String warningByEmployee;
	
	@Column(name = "warning_date")
	private LocalDate warningDate;
	
	@Column(name = "description")
	private String description;
}
