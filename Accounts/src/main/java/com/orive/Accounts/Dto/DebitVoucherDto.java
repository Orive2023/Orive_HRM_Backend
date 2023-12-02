package com.orive.Accounts.Dto;

import java.util.List;

import com.orive.Accounts.Entity.DebitVoucherTableEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DebitVoucherDto {

    private Long debitVoucherId;
	private String voucherType;
	private String creditAccountHead;
	private String date;
	private String remark;
	private List<DebitVoucherTableEntity> debitVoucherTableEntities;
	private double total;
}
