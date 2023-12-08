package com.orive.Employee.Dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

import com.orive.Employee.Entity.ComplaintsEntity;

import jakarta.persistence.Column;
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
public class ComplaintsDto {
		
	    private Long complaintsId;
		private String complaintFrom;
		private String complaintTitle;
		private LocalDate complaintDate;
		private String complaintAgainst;
		private String description;

}
