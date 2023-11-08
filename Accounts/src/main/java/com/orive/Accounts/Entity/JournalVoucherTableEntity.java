package com.orive.Accounts.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "journal_voucher_table")
public class JournalVoucherTableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long journalVoucherTableId;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "sub_type")
	private String subType;
	
	@Column(name = "ledger_comment")
	private String ledgerComment;
	
	@Column(name = "debit")
	private double debit;
	
	@Column(name = "credit")
	private double credit;
	
	@Column(name = "reverse_account_head")
	private String reverseAccountHead;
}
