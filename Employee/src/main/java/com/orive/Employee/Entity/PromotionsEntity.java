package com.orive.Employee.Entity;

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
@Table(name = "promotions")
public class PromotionsEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionsId;
	
	@Column(name = "employee_name")
	private String employeeName;
	

	@Column(name = "promotion_title")
	private String promotionTitle;
	
	
	@Column(name = "promotion_date")
	private String promotionDate;
	
	
	@Column(name = "description")
	private String description;

}
