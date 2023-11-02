package com.orive.Accounts.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceDto {
	
    private Long accountBalancesId;
	private String employeeFullName;
	private String employeeId;
	private String department;
	private String employeePosition;
	private double hsaBalance;
	private double fsaBalance;
	private double retirementAccountBalance;
	private double otherBenefitsAccountsBalance;
	private double expenseReimbursementAccountBalance;
	private String details;
	private int vacationDaysBalance;
	private int sickDaysBalance;
	private int personalDaysBalance;
	private int floatingHolidaysBalance;
	private String accountType;
	private double accountBalance;
	private String purpose;
	private String comments;
}
