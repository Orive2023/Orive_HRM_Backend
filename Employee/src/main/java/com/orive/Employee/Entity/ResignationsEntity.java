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
@Table(name = "resignations")
public class ResignationsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resignationId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "notice_date")
	private String noticeDate;
	
	@Column(name = "resignation_date")
	private String resignationDate;
	
	@Column(name = "resignation_reason")
	private String resignationReason;

	
}
