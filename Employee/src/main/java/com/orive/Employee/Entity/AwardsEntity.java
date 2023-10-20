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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "awards")
public class AwardsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long awardId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "award_name")
	private String awardName;
	
	@Column(name = "gift")
	private String gift;
	
	@Column(name = "cash_price")
	private Long cashPrice;
	
	@Column(name = "award_date")
	private String awardDate;
}
