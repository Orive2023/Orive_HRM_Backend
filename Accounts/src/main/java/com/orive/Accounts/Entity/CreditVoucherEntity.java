package com.orive.Accounts.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "credit_voucher")
public class CreditVoucherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long creditVoucherId;
	
	@Column(name = "voucher_type")
	private String voucherType;
	
	@Column(name = "debit_account_head")
	private String debitAccountHead;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "remark")
	private String remark;
	
	@OneToMany(targetEntity = CreditVoucherTableEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "creditvoucher_table_fk",referencedColumnName = "creditVoucherId")
	private List<CreditVoucherTableEntity> creditVoucherTableEntities;
	
	@Column(name = "total")
	private double total;
}
