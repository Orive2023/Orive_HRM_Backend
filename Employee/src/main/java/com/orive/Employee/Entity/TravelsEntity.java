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
@Table(name = "travels")
public class TravelsEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "purpose_of_visit")
	private String purposeOfVisit;
	
	@Column(name = "place_of_visit")
	private String placeOfVisit;
	
	@Column(name = "travel_mode")
	private String travelMode;
	
	@Column(name = "arrangement_type")
	private String arrangementType;
	
	@Column(name = "expected_travel_budget")
	private double expectedTravelBudget;
	
	@Column(name = "actual_travel_budget")
	private double actualTravelBudget;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
}
