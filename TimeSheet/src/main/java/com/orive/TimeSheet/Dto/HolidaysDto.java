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
public class HolidaysDto {

    private Long holidaysId;
	private String eventName;
	private String startDate;
	private String endDate;
	private String description;
	private String status;
}
