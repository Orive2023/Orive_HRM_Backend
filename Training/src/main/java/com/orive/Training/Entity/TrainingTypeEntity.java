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
@Table(name = "training_type")
public class TrainingTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainingTypeId;
	
	@Column(name = "workshop")
	private String workshop;
	
	@Column(name = "seminar")
	private String seminar;
	
	@Column(name = "webinar")
	private String webinar;
	
	@Column(name = "online_course")
	private String onlineCourse;
	
	@Column(name = "on_the_job_training")
	private String onTheJobTraining;
	
	@Column(name = "certification_programme")
	private String certificationProgramme;
	
	@Column(name = "conference")
	private String conference;
	
	@Column(name = "e_learning_module")
	private String eLearningModule;
	
	@Column(name = "mentoring")
	private String mentoring;
	
	@Column(name = "cross_training")
	private String crossTraining;
	
	@Column(name = "leadership_development")
	private String leadershipDevelopment;
	
	@Column(name = "soft_skills_training")
	private String softSkillsTraining;
	
	@Column(name = "technical_training")
	private String technicalTraining;
	
	@Column(name = "safety_training")
	private String safetyTraining;
	
	@Column(name = "diversity_and_inclusion_training")
	private String diversityAndInclusionTraining;
	
	@Column(name = "compliance_training")
	private String complianceTraining;
	
	@Column(name = "sales_training")
	private String salesTraining;
	
	@Column(name = "customer_service_training")
	private String customerServiceTraining;
}
