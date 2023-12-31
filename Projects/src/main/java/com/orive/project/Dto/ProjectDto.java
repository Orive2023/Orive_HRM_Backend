package com.orive.project.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.orive.project.Entity.EmployeeProjectManagementEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class ProjectDto {
	
	private long projectsId;
	private String projectTitle;
//	private Long employeeId;
	private String clientName;
	private String companyName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String priority;
	private double budget;
	private String projectManagers;
	private String summary;
	private String description;
    private List<EmployeeProjectManagementDto> employeeProjectManagementEntities;
}
