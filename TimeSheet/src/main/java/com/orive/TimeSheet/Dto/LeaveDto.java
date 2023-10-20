package com.orive.TimeSheet.Dto;

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
	private String startDate;
	private String endDate;
	private String employeeName;
	private String leaveReason;
	private String remars;
}
