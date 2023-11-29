package com.orive.Organisation.Dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CompanyDto {

	
	private Long companyId;
	private String companyName;
	private String incomeTaxNumber;
	private String companyType;
	private String legalOrTradingName;
	private String address;
	private String registrationNumber;
	private Long contactNumber;
	private String email;
	private String website;
	private String city;
	private String state;
	private int zipCode;
	private String country;
	private String cin;
	private String gst;
	private String uan;
	private Date date;
	private String status;
	private String approvedBy;
	private byte[] companyLogo;
}
