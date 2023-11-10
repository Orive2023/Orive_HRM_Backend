package com.orive.Employee.Entity;

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
	
	@Column(name = "complaint_from_employee")
	private String complaintFromEmployee;

	@Column(name = "complaint_title")
	private String complaintTitle;
	
	@Column(name = "complaint_date")
	private String complaintDate;
	
	@Column(name = "complaint_against_employee")
	private String complaintAgainstEmployee;
	
	@Column(name = "description")
	private String description;

}
