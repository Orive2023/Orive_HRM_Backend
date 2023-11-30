package com.orive.Employee.Dto;

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
public class AwardsDto {

	private Long awardId;
	private String awardName;
	private String awardDescription;
	private String giftItem;
	private Date date;
	private String employeeName;
	private String awardBy;
}
