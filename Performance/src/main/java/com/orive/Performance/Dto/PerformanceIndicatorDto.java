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
public class PerformanceIndicatorDto {
	
	private Long performancceIndicatorId;
	private String employeeName;
	private String employeeId;
	private String department;
	private String jobTitle;
	private String reviewPeriod;
	private int communicationSkillsRating;
	private String communicationSkillsComments;
	private int teamworkRating;
	private String teamworkComments;
	private int punctualityRating;
	private String punctualityComments;
	private int problemSolvingAbilityRating;
	private String problemSolvingAbilityComments;
	private int adaptabilityRating;
	private String adaptabilityComments;
	private int qualityOfWorkRating;
	private String qualityOfWorkComments;
	private int leadershipSkillsRating;
	private String leadershipSkillsComments;
	private String managersComments;
	private int overallPerformanceRating;
	private String overallPerformanceComments;
	private String goalsAndDevelopmentPlan;

}
