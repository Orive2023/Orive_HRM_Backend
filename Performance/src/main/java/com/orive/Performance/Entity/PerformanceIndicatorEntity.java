package com.orive.Performance.Entity;

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
@Table(name = "performance_indicator")
public class PerformanceIndicatorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long performancceIndicatorId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "review_period")
	private String reviewPeriod;
	
	@Column(name = "communication_skills_rating")
	private int communicationSkillsRating;
	
	@Column(name = "communication_skills_comments")
	private String communicationSkillsComments;
	
	@Column(name = "teamwork_rating")
	private int teamworkRating;
	
	@Column(name = "teamwork_comments")
	private String teamworkComments;
	
	@Column(name = "punctuality_rating")
	private int punctualityRating;
	
	@Column(name = "punctuality_comments")
	private String punctualityComments;
	
	@Column(name = "problem_solving_ability_rating")
	private int problemSolvingAbilityRating;
	
	@Column(name = "problem_solving_ability_comments")
	private String problemSolvingAbilityComments;
	
	@Column(name = "adaptability_rating")
	private int adaptabilityRating;
	
	@Column(name = "adaptability_comments")
	private String adaptabilityComments;
	
	@Column(name = "quality_of_work_rating")
	private int qualityOfWorkRating;
	
	@Column(name = "quality_of_work_comments")
	private String qualityOfWorkComments;
	
	@Column(name = "leadership_skills_rating")
	private int leadershipSkillsRating;
	
	@Column(name = "leadership_skills_comments")
	private String leadershipSkillsComments;
	
	@Column(name = "managers_comments")
	private String managersComments;
	
	@Column(name = "overall_performance_rating")
	private int overallPerformanceRating;
	
	@Column(name = "overall_performance_comments")
	private String overallPerformanceComments;
	
	@Column(name = "goals_and_development_plan")
	private String goalsAndDevelopmentPlan;
}
