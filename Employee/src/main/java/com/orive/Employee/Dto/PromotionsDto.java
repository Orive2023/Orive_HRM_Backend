package com.orive.Employee.Dto;

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
public class PromotionsDto {
	
	    private Long promotionsId;
		private String employeeName;
		private String promotionTitle;
		private String promotionDate;
		private String description;

}