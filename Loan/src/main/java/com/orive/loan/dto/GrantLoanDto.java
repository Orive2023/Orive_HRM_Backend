package com.orive.loan.dto;

import jakarta.persistence.Column;
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
public class GrantLoanDto {
	
	private Long grantLoanId;
	private String employeeName;
	private String permittedBy;
	private String loanDetails;
	private String approveDate;
	private String repaymentForm;
	private double Amount;
	private double interestPersentage;
	private int installmentPeriod;
	private double repaymentTotal;
	private int installment;
	private String status;
}
