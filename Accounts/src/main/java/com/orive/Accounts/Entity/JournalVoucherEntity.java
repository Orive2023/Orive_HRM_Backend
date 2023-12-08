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
@Table(name = "journal_voucher")
public class JournalVoucherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long journalVoucherId;
	
	@Column(name = "journal_voucher")
	private String journalVoucher;
	
	@Column(name = "voucher_type")
	private String voucherType;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "remark")
	private String remark;
	
	@OneToMany(targetEntity = JournalVoucherTableEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "journalvoucher_table_fk",referencedColumnName = "journalVoucherId")
	private List<JournalVoucherTableEntity> journalVoucherTableEntities;
	
	@Column(name = "total_credit")
	private double totalCredit;
	
	@Column(name = "total_debit")
	private double totalDebit;
}
