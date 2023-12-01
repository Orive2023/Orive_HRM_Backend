package com.orive.project.Dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
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
public class ProjectDto {
	
    private long projectsId;
	private String projectTitle;
	private String clientName;
	private String companyName;
	private Date startDate;
	private Date endDate;
	private String priority;
	private double budget;
	private String projectManagers;
	private String summary;
	private String description;
}
