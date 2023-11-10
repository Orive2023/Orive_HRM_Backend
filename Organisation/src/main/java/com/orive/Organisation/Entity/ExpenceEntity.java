package com.orive.Organisation.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "expence")
public class ExpenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expenceId;
	
	@Column(name = "expence_type")
	private String expenceType;
	
	@Column(name = "purchase_date")
	private String purchaseDate;
	
	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "purchase_by")
	private String purchaseBy;
	
	@Column(name = "bill_copy")
	private String  billCopy;
	
	@Column(name = "remarks")
	private String remarks;
}
