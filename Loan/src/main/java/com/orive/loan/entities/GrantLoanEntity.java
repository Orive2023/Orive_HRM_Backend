package com.orive.loan.entities;

import java.time.ZonedDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "grantloan")
public class GrantLoanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grantLoanId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "permitted_by")
	private String permittedBy;
	
	@Column(name = "loan_details")
	private String loanDetails;
	
	@Column(name = "approve_date")
	private ZonedDateTime approveDate;
	
	@Column(name = "repayment_form")
	private ZonedDateTime repaymentForm;
	
	@Column(name = "Amount")
	private double Amount;
	
	@Column(name = "interest_persentage")
	private double interestPersentage;
	
	@Column(name = "installment_period")
	private int installmentPeriod;
	
	@Column(name = "repayment_total")
	private double repaymentTotal;
	
	@Column(name = "installment")
	private int installment;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "installment_cleared")
	private int installmentCleared;
	
	@Column(name = "total_payment_cleared")
	private double totalPaymentCleared;
}
