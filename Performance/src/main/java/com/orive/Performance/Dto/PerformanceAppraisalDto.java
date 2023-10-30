package com.orive.Performance.Dto;

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
public class PerformanceAppraisalDto {
	
    private Long performanceAppraisalId;
	private String employeeName;
	private String employeeIdNumber;
	private String DepartmentName;
	private String jobTitle;
	private String appraisalPeriod;
	private int qualityOfWorkRating;
	private String qualityOfWorkComments;
	private int jobKnowledgeRating;
	private String jobKnowledgeComments;
	private int communicationSkillsRating;
	private String CommunicationSkillsComments;
	private int teamworkAndCollaborationRating;
	private String teamworkAndCollaborationComments;
	private int initiativeAndCreativityRating;
	private String initiativeAndCreativityComments;
	private int punctualityAndAttendanceRating;
	private String punctualityAndAttendanceComments;
	private int adaptabilityRating;
	private String adaptabilityComments;
	private int overallRating;
	private String overallComments;
	private String strengths;
	private String areasForImprovement;
	private String employeesSelfAssessment;
	private String goalsAchieved;
	private String developmentPlan;
	private String managersComments;
	private String employeesSignature;
	private String employeesSignatureDate;
	private String managersSignature;
	private String managersSignatureDate;


}
