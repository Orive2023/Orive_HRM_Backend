package com.orive.Procurement.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Entity
@Table(name = "bid_analysis")
public class BidAnalysisEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bidAnalysisId;
	
	@Column(name = "location")
	private String location;

	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "quotation")
	private String quotation;
	
	@Lob
	@Column(name = "attachment", length = 100000)
	private byte[] attachment;
	
	@Transient
	private List<CommitteeListEntity> committeeListEntities = new ArrayList<>();

	@Transient
	private List<CompanyListEntity> companyListEntities = new ArrayList<>();

	
//	@OneToMany(targetEntity = CommitteeListEntity.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "bidAnalysis_committee_fk",referencedColumnName = "bidAnalysisId")
//	private List<CommitteeListEntity> committeeEntities;
	
	
//	@OneToMany(targetEntity = CompanyListEntity.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "bidAnalysis_company_fk",referencedColumnName = "bidAnalysisId")
//	private List<CompanyListEntity> companyListEntities;
}
