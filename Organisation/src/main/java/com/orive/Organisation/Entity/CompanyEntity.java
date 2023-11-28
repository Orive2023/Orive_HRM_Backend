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
@Table(name = "company")
public class CompanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "income_tax_number")
	private String incomeTaxNumber;
	
	@Column(name = "company_type")
	private String companyType;
	
	@Column(name = "legal_or_tranding_name")
	private String legalOrTrandingName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "registration_number")
	private String registrationNumber;
	
	@Column(name = "contact_number")
	private Long contactNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private int zipCode;
	
	@Column(name = "country")
	private String country;
	
	
	@Column(name = "cin")
	private String cin;
	
	@Column(name = "gst")
	private String gst;
	
	@Column(name = "uan")
	private String uan;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "approved_by")
	private String approvedBy;
	
	@Lob
	@Column(name = "company_logo",length = 100000)
	private byte[] companyLogo;
}
