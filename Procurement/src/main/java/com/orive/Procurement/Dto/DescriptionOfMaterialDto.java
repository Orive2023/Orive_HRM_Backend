package com.orive.Procurement.Dto;

import java.util.List;

import com.orive.Procurement.Entity.DescriptionOfMaterialEntity;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionOfMaterialDto {
	
	private Long descriptionOfMaterialId;
	
	private String descriptionOfMaterialOrGoodsOrService;
	
	private String unit;
	
	private Double quantity;

}
