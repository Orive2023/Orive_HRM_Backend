package com.orive.Accounts.Dto;

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
public class AccountListDto {
	
	private Long accountListId;	
	private String employeeFullName;
	private Long employeeId;
	private String department;
	private String position;
	private String bankName;
	private String accountHolderName;
	private Long accountNumber;
	private Long routingNumber;
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
