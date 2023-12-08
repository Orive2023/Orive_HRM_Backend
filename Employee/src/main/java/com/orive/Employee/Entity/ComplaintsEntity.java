package com.orive.Employee.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "complaints")
public class ComplaintsEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintsId;
	
	@Column(name = "complaint_from")
	private String complaintFrom;

	@Column(name = "complaint_title")
	private String complaintTitle;
	
	@Column(name = "complaint_date")
	private LocalDate complaintDate;
	
	@Column(name = "complaint_against")
	private String complaintAgainst;
	
	@Column(name = "description")
	private String description;
}
