package com.orive.Tickets.Entity;

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
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "project")
	private Date project;
}
