package com.orive.Procurement.Entity;

import java.time.LocalDate;
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
@Table(name = "good_received")
public class GoodReceivedEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long goodReceivedId;
	
	@Column(name = "purchase_order")
	private String purchaseOrder;
	
	@Column(name = "payment_source")
	private String paymentSource;
	
	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "received_by_name")
	private String receivedByName;
	
	@Column(name = "title")
	private String title;
	
	@Lob
	@Column(name = "signature_and_stamp", length = 100000)
	private byte[] signatureAndStamp;
	
	@OneToMany(targetEntity = GoodReceivedListEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "goodReceived_list_fk",referencedColumnName = "goodReceivedId")
	private List<GoodReceivedListEntity> goodReceivedListEntities;

}
