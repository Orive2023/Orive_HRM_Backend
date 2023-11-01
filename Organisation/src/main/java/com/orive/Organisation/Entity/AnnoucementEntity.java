package com.orive.Organisation.Entity;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "announcements")
public class AnnoucementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long announcementsId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "location_name")
	private String locationName;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "description")
	private List<String> description;
}
