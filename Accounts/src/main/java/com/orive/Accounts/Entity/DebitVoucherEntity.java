package com.orive.Accounts.Entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "debit_voucher")
public class DebitVoucherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long debitVoucherId;
	
	@Column(name = "voucher_type")
	private String voucherType;
	
	@Column(name = "credit_account_head")
	private String creditAccountHead;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "remark")
	private String remark;
	
	@OneToMany(targetEntity = DebitVoucherTableEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "debit_voucher_table_fk",referencedColumnName = "debitVoucherId")
	private List<DebitVoucherTableEntity> debitVoucherTableEntities;
	
	@Column(name = "total")
	private double total;
}
