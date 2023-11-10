package com.orive.Organisation.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "company_details")
public class CompanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_type")
	private String companyType;
	
	@Column(name = "legal_or_tranding_name")
	private String legalOrTrandingName;
	
	@Column(name = "cin")
	private String cin;
	
	@Column(name = "contact_number")
	private Long contactNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "gst")
	private String gst;
	
	@Column(name = "uan")
	private String uan;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "company_logo")
	private String companyLogo;
}
