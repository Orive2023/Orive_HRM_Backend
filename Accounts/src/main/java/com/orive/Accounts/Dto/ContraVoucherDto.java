package com.orive.Accounts.Dto;

import java.time.ZonedDateTime;
import java.util.List;

import com.orive.Accounts.Entity.ContraVoucherListEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	private ZonedDateTime date;
	private String remark;
	private List<ContraVoucherListDto> contraVoucherListEntities;

}
