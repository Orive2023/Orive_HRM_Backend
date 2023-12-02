package com.orive.Accounts.Dto;

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
	private String financialYearStartDate;
	private String financialYearEndDate;
}
