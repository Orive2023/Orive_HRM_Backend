package com.orive.Organisation.Dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String companyType;
	private String legalOrTrandingName;
	private String cin;
	private Long contactNumber;
	private String email;
	private String website;
	private String gst;
	private String uan;
	private String address;
	private String status;
	private boolean approvedBy;
	private byte[] companyLogo;
}
