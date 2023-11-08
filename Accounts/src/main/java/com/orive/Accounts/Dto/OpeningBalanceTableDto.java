package com.orive.Accounts.Dto;

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
public class OpeningBalanceTableDto {

    private Long openingBalanceTableId;
	private String accountNumber;
	private String subType;
	private double debit;
	private double credit;
}
