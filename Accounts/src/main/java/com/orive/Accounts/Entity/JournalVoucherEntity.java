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
@Table(name = "journal_voucher")
public class JournalVoucherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long journalVoucherId;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "remark")
	private String remark;
	
	@OneToMany(targetEntity = JournalVoucherTableEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "journal_voucher_table_fk",referencedColumnName = "journalVoucherId")
	private List<JournalVoucherTableEntity> journalVoucherTableEntities;
	
	@Column(name = "total_credit")
	private double totalCredit;
	
	@Column(name = "total_debit")
	private double totalDebit;
}
