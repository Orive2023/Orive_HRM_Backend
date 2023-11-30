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
@Table(name = "performanceappraisal")
public class PerformanceAppraisalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long performanceAppraisalId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "Department_name")
	private String departmentName;
		
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "appraisal_period")
	private String appraisalPeriod;
	
	@Column(name = "quality_of_work_rating")
	private int qualityOfWorkRating;
	
	@Column(name = "quality_of_work_comments")
	private String qualityOfWorkComments;
	
	@Column(name = "quality_of_work_rating_score")
	private Long qualityOfWorkRatingScore;
	
	@Column(name = "job_knowledge_rating")
	private int jobKnowledgeRating;
	
	@Column(name = "job_knowledge_comments")
	private String jobKnowledgeComments;
	
	@Column(name = "communication_skills_rating")
	private int communicationSkillsRating;

	@Column(name = "communication_skills_comments")
	private String communicationSkillsComments;
	
	@Column(name = "communicationSkillsScore")
	private Long communicationSkillsScore;
	
	@Column(name = "teamwork_and_collaboration_rating")
	private int teamworkAndCollaborationRating;
	
	@Column(name = "teamwork_and_collaboration_comments")
	private String teamworkAndCollaborationComments;
	
	@Column(name = "teamworkAndCollaborationScore")
	private Long teamworkAndCollaborationScore;
	
	@Column(name = "initiative_and_creativity_rating")
	private int initiativeAndCreativityRating;
	
	@Column(name = "initiative_and_creativity_comments")
	private String initiativeAndCreativityComments;
	
	@Column(name = "initiativeAndCreativityScore")
	private Long initiativeAndCreativityScore;
	
	@Column(name = "punctuality_and_attendance_rating")
	private int punctualityAndAttendanceRating;
	
	@Column(name = "punctuality_and_attendance_comments")
	private String punctualityAndAttendanceComments;
	
	@Column(name = "punctualityAndAttendanceScore")
	private Long punctualityAndAttendanceScore;
	
	@Column(name = "adaptability_rating")
	private int adaptabilityRating;
	
	@Column(name = "adaptability_comments")
	private String adaptabilityComments;
	
	@Column(name = "adaptabilityScore")
	private Long adaptabilityScore;
	
	@Column(name = "overall_rating")
	private int overallRating;
	
	@Column(name = "overall_comments")
	private String overallComments;
	
	@Column(name = "overallScore")
	private Long overallScore;
	
	@Column(name = "areas_for_improvement")
	private String areasForImprovement;
	
	@Column(name = "employees_self_assessment")
	private String employeesSelfAssessment;
	
	@Column(name = "goals_achieved")
	private String goalsAchieved;
	
	@Column(name = "development_plan")
	private String developmentPlan;
	
	@Column(name = "managers_comments")
	private String managersComments;
	
}
