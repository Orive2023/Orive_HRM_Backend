package com.orive.Procurement.Dto;

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
public class VendorDto {
 
	private Long vendorId;
	private String vendorName;
	private Long mobileNo;
	private String emailAddress;
	private String address;
	private String country;
	private String city;
	private String zipCode;
	private double previousBalance;

}
