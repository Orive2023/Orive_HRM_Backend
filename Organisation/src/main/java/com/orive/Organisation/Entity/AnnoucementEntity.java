package com.orive.Organisation.Entity;



import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "announcements")
public class AnnoucementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long announcementsId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "location_name")
	private String locationName;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "summary")
	private String summary;
		
	@Column(name = "description",length = 100000)
	private String description;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
//	@Column(name = "status")
//	private String status;
//	
//	@Column(name = "approved_by")
//	private String approvedBy;
}
