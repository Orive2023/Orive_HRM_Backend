package com.orive.loan.dto;

import java.time.ZonedDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrantLoanDto {
	
	private Long grantLoanId;
	private String employeeName;
	private String permittedBy;
	private String loanDetails;
	private ZonedDateTime approveDate;
	private ZonedDateTime repaymentForm;
	private double Amount;
	private double interestPersentage;
	private int installmentPeriod;
	private double repaymentTotal;
	private int installment;
	private String status;
	private int installmentCleared;
	private double totalPaymentCleared;
}
