package com.orive.TimeSheet.Dto;

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
public class LeaveDto {

    private Long leaveId;
	private String leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String employeeName;
	private String leaveReason;
	private String Description;
	private LocalDate appliedOn;
}
