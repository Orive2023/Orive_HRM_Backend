package com.orive.PayeesAndPayers.Dto;

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
public class PayersDto {
	
    private Long payersId;
	private String employeeFullName;
	private Long employeeId;
	private String employeeEmailAddress;
	private String payersAccountNumber;
	private double amount;
	private String currency;
	private String paymentType;
	private String payerAccount;
	private String payerWalletAddress;
	private String transactionId;
	private String transactionDate;
	private String transactionStatus;
	private String purposeOfPayment;
	private String transactionNotes;
	private String securityToken;
	private String twoFactorAuthentication;
}
