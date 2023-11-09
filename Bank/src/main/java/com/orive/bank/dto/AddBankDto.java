package com.orive.bank.dto;

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
public class AddBankDto {
	
    private Long addBankId;
	private String bankName;
	private String accountName;
	private String accountNumber;
	private String branchName;

}
