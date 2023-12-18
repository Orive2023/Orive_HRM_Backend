package com.orive.Procurement.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name = "quotation")
public class QuotationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quotationId;
	
	@Column(name = "name_of_company")
	private String nameOfCompany;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "pin_or_equivalent")
	private Long pinOrEquivalent;
	
	@Column(name = "expected_date_of_delivery")
	private LocalDate expectedDateOfDelivery;
	
	@Column(name = "place_of_delivery")
	private String placeOfDelivery;
	
	@Lob
	@Column(name = "signature_and_stamp", length = 100000)
	private byte[] signatureAndStamp;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Transient
	private List<QuotationListEntity> quotationListEntities=new ArrayList<>();
}
