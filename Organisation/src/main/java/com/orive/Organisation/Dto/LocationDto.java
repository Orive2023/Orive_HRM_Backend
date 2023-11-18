package com.orive.Organisation.Dto;

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
	private String locationName;
	private String email;
	private Long phone;
	private String faxNumber;
	private String locationHead;
	private String locationHrManager;
	private String address;
	private String status;
	private boolean approvedBy;

}
