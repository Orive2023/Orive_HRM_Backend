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
@Table(name = "contra_voucher")
public class ContraVoucherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contraVoucherId;
	
	@Column(name = "voucher_type")
	private String voucherType;
	
	@Column(name = "reversed_account_head")
	private String reversedAccountHead;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "remark")
	private String remark;

	@OneToMany(targetEntity =  ContraVoucherListEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "contra_voucher_table_fk",referencedColumnName = "contraVoucherId")
	private List<ContraVoucherListEntity> contraVoucherListEntities;
}
