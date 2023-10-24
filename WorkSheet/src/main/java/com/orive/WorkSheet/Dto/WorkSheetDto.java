package com.orive.WorkSheet.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkSheetDto {

    private Long workSheetId;
	private String title;
	private String startDate;
	private String endDate;
	private double estimateHour;
	private String project;
	private String assignedTo;
	private String description;
}
