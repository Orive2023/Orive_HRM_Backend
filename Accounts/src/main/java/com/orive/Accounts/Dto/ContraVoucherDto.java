package com.orive.Accounts.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContraVoucherDto {

	private Long contraVoucherId;
	private String voucherType;
	private String reverseAccountHead;
	private String date;
	private String remark;
	private String accountName;
	private String ledgerComment;
	private double debit;
	private double credit;
}
