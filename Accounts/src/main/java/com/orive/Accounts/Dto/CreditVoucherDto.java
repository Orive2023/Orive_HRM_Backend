package com.orive.Accounts.Dto;

import java.util.List;

import com.orive.Accounts.Entity.CreditVoucherTableEntity;

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
public class CreditVoucherDto {

	private Long creditVoucherId;
	private String voucherType;
	private String debitAccountHead;
	private String date;
	private String remark;
	private List<CreditVoucherTableEntity> creditVoucherTableEntities;
	private double total;
}
