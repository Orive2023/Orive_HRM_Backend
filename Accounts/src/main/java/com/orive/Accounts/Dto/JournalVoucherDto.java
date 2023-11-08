package com.orive.Accounts.Dto;

import java.util.List;

import com.orive.Accounts.Entity.JournalVoucherTableEntity;

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
public class JournalVoucherDto {

    private Long journalVoucherId;
	private String date;
	private String remark;
	private List<JournalVoucherTableEntity> journalVoucherTableEntities;
	private double totalCredit;
	private double totalDebit;
}
