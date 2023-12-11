package com.orive.project.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
@Table(name = "projects")
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectsId;
	
	@Column(name = "project_title")
	private String projectTitle;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date" )
	private LocalDate endDate;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "budget")
	private double budget;
	
	@Column(name = "project_managers")
	private String projectManagers;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "description")
	private String description;
}
