package com.orive.Organisation.Dto;

import java.util.Date;
import java.util.List;

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
public class AnnoucementDto {

	private Long announcementsId;
	private String title;
	private String startDate;
	private String endDate;
	private String companyName;
	private String locationName;
	private String departmentName;
	private String summary;
	private String description;
	private Date createdDate;
//	private String status;
//	private String approvedBy;
}
