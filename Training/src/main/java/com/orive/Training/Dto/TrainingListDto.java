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
public class TrainingListDto {
	
    private Long trainingListId;
	private String employeesFullName;
	private String employeeId;
	private String department;
	private String jobPosition;
	private String dateOfTraining;
	private String trainingTitle;
	private String trainingProvider;
	private String trainingLocation;
	private String trainingDuration;
	private String trainingType;
	private String trainingObjectives;
	private String topicsCovered;
	private String trainingMethods;
	private String trainingOutcomes;
	private String participantFeedback;
	private String trainersEvaluation;
	private int overallTrainingRating;
	private String actionItems;
	private String trainingCoordinatorName;
}
