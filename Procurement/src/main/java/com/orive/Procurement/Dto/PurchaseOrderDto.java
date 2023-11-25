package com.orive.Procurement.Dto;

import jakarta.persistence.Column;
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
public class PurchaseOrderDto {
	
    private Long purchaseOrderId;
	private String quotation;
	private String location;
	private String vendorName;
	private String address;
	private String authorizedByName;
	private String title;
	private String signatureAndStamp;
	private String date;

}
