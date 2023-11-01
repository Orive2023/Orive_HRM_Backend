package com.orive.Training.Entity;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "training_list")
public class TrainingListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainingListId;
	
	@Column(name = "employees_full_name")
	private String employeesFullName;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "job_position")
	private String jobPosition;
	
	@Column(name = "date_of_training")
	private String dateOfTraining;
	
	@Column(name = "training_title")
	private String trainingTitle;
	
	@Column(name = "training_provider")
	private String trainingProvider;
	
	@Column(name = "training_location")
	private String trainingLocation;
	
	@Column(name = "training_duration")
	private String trainingDuration;
	
	@Column(name = "training_type")
	private String trainingType;
	
	@Column(name = "training_objectives")
	private String trainingObjectives;
	
	@Column(name = "topics_covered")
	private String topicsCovered;
	
	@Column(name = "training_methods")
	private String trainingMethods;
	
	@Column(name = "training_outcomes")
	private String trainingOutcomes;
	
	@Column(name = "participant_feedback")
	private String participantFeedback;
	
	@Column(name = "trainers_evaluation")
	private String trainersEvaluation;
	
	@Column(name = "overall_training_rating")
	private int overallTrainingRating;
	
	@Column(name = "action_items")
	private String actionItems;
	
	@Column(name = "training_coordinator_name")
	private String trainingCoordinatorName;
}
