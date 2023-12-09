package com.orive.Performance.Dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PerformanceAppraisalDto {
	
    private Long performanceAppraisalId;
	private String employeeName;
	private Long employeeId;
	private String departmentName;
	private String position;
	private LocalDate appraisalPeriod;
	private int qualityOfWorkRating;
	private String qualityOfWorkComments;
	private Long qualityOfWorkScore;
	private int jobKnowledgeRating;
	private String jobKnowledgeComments;
	private Long jobKnowledgeScore;
	private int communicationSkillsRating;
	private String communicationSkillsComments;
	private Long communicationSkillsScore;
	private int teamworkAndCollaborationRating;
	private String teamworkAndCollaborationComments;
	private Long teamworkAndCollaborationScore;
	private int initiativeAndCreativityRating;
	private String initiativeAndCreativityComments;
	private Long initiativeAndCreativityScore;
	private int punctualityAndAttendanceRating;
	private String punctualityAndAttendanceComments;
	private Long punctualityAndAttendanceScore;
	private int adaptabilityRating;
	private String adaptabilityComments;
	private Long adaptabilityScore;
	private int overallRating;
	private String overallComments;
	private Long overallScore;
	private String areasForImprovement;
	private String employeesSelfAssessment;
	private String goalsAchieved;
	private String developmentPlan;
	private String managersComments;	
}
