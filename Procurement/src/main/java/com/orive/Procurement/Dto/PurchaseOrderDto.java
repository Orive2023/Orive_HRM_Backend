package com.orive.Procurement.Dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
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
public class PurchaseOrderDto {
	
    private Long purchaseOrderId;
	private String quotation;
	private String location;
	private String vendorName;
	private String address;
	private String notes;
	private String authorizedByName;
	private String title;
	private byte[] signatureAndStamp;
	private LocalDate date;
	private List<PurchaseOrderListDto> purchaseOrderListEntities;
}
