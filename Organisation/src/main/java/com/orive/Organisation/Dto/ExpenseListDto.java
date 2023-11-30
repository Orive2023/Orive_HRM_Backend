package com.orive.Organisation.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ExpenseListDto {

	
	private Long expenceListId;
	
	private String purchaseDate;
	
	private String description;
	
	private String purchasedBy;
	
	private Long amount;		
}
