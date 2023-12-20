package com.orive.Accounts.Entity;

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
@Table(name = "account_balances")
public class AccountBalancesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountBalancesId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "hsa_balance")
	private double hsaBalance;
	
	@Column(name = "fsa_balance")
	private double fsaBalance;
	
	@Column(name = "retirement_account_balance")
	private double retirementAccountBalance;
	
	@Column(name = "other_benefits_accounts_balance")
	private double otherBenefitsAccountsBalance;
	
	@Column(name = "expense_reimbursement_account_balance")
	private double expenseReimbursementAccountBalance;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "vacation_days_balance")
	private int vacationDaysBalance;
	
	@Column(name = "sick_days_balance")
	private int sickDaysBalance;
	
	@Column(name = "personal_days_balance")
	private int personalDaysBalance;
	
	@Column(name = "floating_holidays_balance")
	private int floatingHolidaysBalance;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "account_balance")
	private double accountBalance;
	
	@Column(name = "purpose")
	private String purpose;
	
	@Column(name = "comments")
	private String comments;
}
