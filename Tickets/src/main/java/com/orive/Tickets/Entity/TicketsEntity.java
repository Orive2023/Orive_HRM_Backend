package com.orive.Tickets.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tickets")
public class TicketsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketsId;
	
	@Column(name = "tickets_code")
	private String ticketsCode;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "project_title")
	private String projectTitle;
	
	@Column(name = "description")
	private String description;
}
