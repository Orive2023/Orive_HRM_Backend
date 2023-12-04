package com.orive.Procurement.Dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class BidAnalysisDto {


	private Long bidAnalysisId;
	
	private String location;
	
	private String quotation;
	
	private Date date;

	private byte[] attachment;

	private List<CommitteeListDto> committeeListDtos;
	
	private List<CompanyListDto> companyListDtos;
}
