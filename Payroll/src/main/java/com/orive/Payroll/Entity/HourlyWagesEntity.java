package com.orive.Payroll.Entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hourly_wages")
public class HourlyWagesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hourlyWagesId;
	
	@Column(name = "hourly_wage_title")
	private String hourlyWageTitle;
	
	@Column(name = "hourly_rate")
	private double hourlyRate;
}
