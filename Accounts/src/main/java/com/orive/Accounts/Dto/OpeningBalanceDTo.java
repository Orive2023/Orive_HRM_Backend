package com.orive.Accounts.Dto;

import java.util.List;

import com.orive.Accounts.Entity.OpeningBalanceTableEntity;

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
public class OpeningBalanceDTo {

    private Long openingBalanceId;
	private String financialYear;
	private String date;
	private List<OpeningBalanceTableDto> openingBalanceTableDtos;
	private double debitTotal;
	private double creditTotal;
}
