package com.orive.Procurement.Dto;

import java.util.List;

import com.orive.Procurement.Entity.DescriptionOfMaterialEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class RequestDto {

	private Long requestId;
	
	private String requestingPerson;
	
	private String requestingDepartment;	
	
	private String expectedTimeToHaveTheGoodStarts;
	
	private String expectedTimeToHaveTheGoodEnds;
	
	private String reasonForRequesting;
	
	private List<DescriptionOfMaterialDto> descriptionOfMaterialEntities;
}
