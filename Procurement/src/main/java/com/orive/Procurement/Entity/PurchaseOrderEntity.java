package com.orive.Procurement.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
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
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "authorized_by_name")
	private String authorizedByName;
	
	@Column(name = "title")
	private String title;
	
	@Lob
	@Column(name = "signature_and_stamp", length = 100000)
	private byte[] signatureAndStamp;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Transient
	private List<PurchaseOrderListEntity> purchaseOrderListEntities = new ArrayList<>();
	
//	@OneToMany(targetEntity = PurchaseOrderListEntity.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "purchaseOrder_list_fk",referencedColumnName = "purchaseOrderId")
//	private List<PurchaseOrderListEntity> purchaseOrderListEntities;
}
