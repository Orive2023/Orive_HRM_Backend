package com.orive.Procurement.Dto;

import java.util.List;

import jakarta.persistence.Column;
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
public class BidAnalysisDto {

    private Long  bidAnalysisId;
	private String location;
	private String quotation;
	private String date;
	private String attachment;
	private List<CommitteeDto> committeeDtos;
}
