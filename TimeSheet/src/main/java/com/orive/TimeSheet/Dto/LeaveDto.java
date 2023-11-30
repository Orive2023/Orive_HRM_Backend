package com.orive.TimeSheet.Dto;

import java.util.Date;

import jakarta.persistence.Column;
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
public class LeaveDto {

    private Long leaveId;
	private String leaveType;
	private Date startDate;
	private Date endDate;
	private String employeeName;
	private String leaveReason;
	private String Description;
	private String appliedOn;
}
