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
public class AccountListDto {
	
	private Long accountListId;	
	private String employeeFullName;
	private String employeeId;
	private String department;
	private String employeePosition;
	private String bankName;
	private String accountHolderName;
	private String accountNumber;
	private String routingNumber;
	private String accountType;
	private String emailAddress;
	private String emailSystem;
	private String userName;
	private String password;
	private String accessLevel;
	private String additionalAccountType;
	private String additionalAccountInformation;
	private String comments;
}
