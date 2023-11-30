package com.orive.Organisation.Dto;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationDto {

    private Long locationId;
	private String companyName;
	private String locationHead;
	private String locationName;
	private String address;	
	private String email;
	private Long phone;
	private String faxNumber;
	private String city;
	private String state;
	private int zipCode;
	private String country;
	private Date date;
//	private String status;
//	private String approvedBy;

}
