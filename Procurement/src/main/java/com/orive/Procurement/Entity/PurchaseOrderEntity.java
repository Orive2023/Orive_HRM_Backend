package com.orive.Procurement.Entity;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchaseOrder")
public class PurchaseOrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseOrderId;
	
	@Column(name = "quotation")
	private String quotation;
	
	@Column(name = "location")
	private String location;

	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "authorized_by_name")
	private String authorizedByName;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "signature_and_stamp")
	private String signatureAndStamp;
	
	@Column(name = "date")
	private String date;
}
