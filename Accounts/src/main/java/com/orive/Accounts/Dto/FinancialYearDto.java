package com.orive.Accounts.Dto;

import java.time.ZonedDateTime;

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
public class FinancialYearDto {

    private Long financialYearId;
	private String financialYear;
	private ZonedDateTime financialYearStartDate;
	private ZonedDateTime financialYearEndDate;
}
