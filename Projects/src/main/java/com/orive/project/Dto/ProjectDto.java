package com.orive.project.Dto;

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
	private String title;
	private String clientName;
	private String companyName;
	private String startDate;
	private String endDate;
	private String priority;
	private String projectManagers;
	private String summary;
	private String description;

}
