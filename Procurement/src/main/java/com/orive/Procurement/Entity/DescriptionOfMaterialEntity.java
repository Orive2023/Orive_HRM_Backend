package com.orive.Procurement.Entity;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "description_of_mterial")
public class DescriptionOfMaterialEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long descriptionOfMaterialId;
	
	@Column(name = "description_of_material_or_goods_or_Service")
	private String descriptionOfMaterialOrGoodsOrService;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "descriptionOfMateriaOrGoodsOrService")
	private Double quantity;
}
