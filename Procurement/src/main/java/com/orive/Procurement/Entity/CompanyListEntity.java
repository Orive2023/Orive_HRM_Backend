package com.orive.Procurement.Entity;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company_list")
public class CompanyListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyListId;
	
	private Long bidAnalysisId;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "reason_of_choosing")
	private String reasonOfChoosing;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "grand_total")
	private double grandTotal;
}
