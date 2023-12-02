package com.orive.Accounts.Dto;

import java.util.List;

import com.orive.Accounts.Entity.ContraVoucherListEntity;


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
public class ContraVoucherDto {

	private Long contraVoucherId;
	private String voucherType;
	private String reversedAccountHead;
	private String date;
	private String remark;
	private List<ContraVoucherListEntity> contraVoucherListEntities;

}
