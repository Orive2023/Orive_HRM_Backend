package com.orive.WorkSheet.Dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class WorkSheetDto {

    private Long workSheetId;
	private String workSheetTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private double estimateHour;
	private String project;
	private String employeeName;
	private String assignedTo;
	private String description;
	private String taskName;
	private String challangePart;
	private String workProgress;
	private LocalDate createdDate;
}
