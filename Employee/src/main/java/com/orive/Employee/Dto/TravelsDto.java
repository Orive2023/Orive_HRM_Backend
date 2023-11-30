package com.orive.Employee.Dto;

import java.util.Date;

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
public class TravelsDto {
	
	    private Long travelId;
		private String employeeName;
		private Date startDate;
		private Date endDate;
		private String purposeOfVisit;
		private String placeOfVisit;
		private String travelMode;
		private String arrangementType;
		private double expectedTravelBudget;
		private double actualTravelBudget;
		private String description;
		private Date createdDate;
}
