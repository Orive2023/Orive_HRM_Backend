package com.orive.TimeSheet.Entity;

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
@Table(name = "holidays")
public class HolidaysEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long holidaysId;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
}
