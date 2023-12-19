package com.orive.Procurement.Entity;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "quotation_list")
public class QuotationListEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quotationListId;
	
	private Long quotationId;
	
	@Column(name = "description_of_materials")
	private String descriptionOfMaterials;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "grand_total")
	private double grandTotal;
}
