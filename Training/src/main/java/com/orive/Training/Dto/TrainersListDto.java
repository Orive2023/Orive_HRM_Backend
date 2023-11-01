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
public class TrainersListDto {
	
    private Long trainersListId;
	private String trainersFullName;
	private String trainersEmailAddress;
	private String trainersPhoneNo;
	private String trainersTechnicalSkills;
	private String trainersSoftSkills;
	private String industries;
	private String certifications;
	private String workshops;
	private String seminars;
	private String webinars;
	private String otherTrainingFormats;
	private String preferredTrainingAudience;
	private String trainingLanguages;
	private String availability;
	private String previousClients;
	private String trainingMaterialsProvided;
	private String additionalNotes;
}
