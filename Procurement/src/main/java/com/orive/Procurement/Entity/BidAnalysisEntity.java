package com.orive.Procurement.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "bid_analysis")
public class BidAnalysisEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bidAnalysisId;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "quotation")
	private String quotation;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "attachment")
	private String attachment;
	
	
	@OneToMany(targetEntity = CommitteeEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "bidAnalysis_committee_fk",referencedColumnName = "bidAnalysisId")
	private List<CommitteeEntity> committeeEntities;
	
	
}
