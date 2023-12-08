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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "awards")
public class AwardsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long awardId;
	
	@Column(name = "award_name")
	private String awardName;
	
	@Column(name = "award_description")
	private String awardDescription;
	
	@Column(name = "gift_item")
	private String giftItem;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "award_by")
	private String awardBy;
}
