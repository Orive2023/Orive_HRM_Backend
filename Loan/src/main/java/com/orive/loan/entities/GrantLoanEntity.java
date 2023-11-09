package com.orive.loan.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private String approveDate;
	
	@Column(name = "repayment_form")
	private String repaymentForm;
	
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
}
