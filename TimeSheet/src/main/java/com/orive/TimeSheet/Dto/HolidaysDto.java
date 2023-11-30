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
public class HolidaysDto {

    private Long holidaysId;
	private String eventName;
	private Date startDate;
	private Date endDate;
	private String description;
}
