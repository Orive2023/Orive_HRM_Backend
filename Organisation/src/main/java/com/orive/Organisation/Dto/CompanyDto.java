package com.orive.Organisation.Dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CompanyDto {

	
	private Long companyId;
	private String companyName;
	private String companyType;
	private String legalOrTrandingName;
	private String registrationNumber;
	private Long contactNumber;
	private String email;
	private String website;
	private String taxNumberOrEin;
	private String address;
 	private MultipartFile companyLogo;
}
