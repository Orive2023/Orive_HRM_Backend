package com.orive.Training.Dto;

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
public class TrainingTypeDto {
	
    private Long trainingTypeId;
	private String workshop;
	private String seminar;
	private String webinar;
	private String onlineCourse;
	private String onTheJobTraining;
	private String certificationProgramme;
	private String conference;
	private String eLearningModule;
	private String mentoring;
	private String crossTraining;
	private String leadershipDevelopment;
	private String softSkillsTraining;
	private String technicalTraining;
	private String safetyTraining;
	private String diversityAndInclusionTraining;
	private String complianceTraining;
	private String salesTraining;
	private String customerServiceTraining;
}
