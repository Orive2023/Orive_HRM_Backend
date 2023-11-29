package com.orive.Organisation.Entity;

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
@Table(name = "designation")
public class DesignationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long designationId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "designation_name")
	private String designationName;
	
	@Column(name = "created_date")
	private Date createdDate;
	
//	@Column(name = "status")
//	private String status;
//	
//	@Column(name = "approved_by")
//	private String approvedBy;
}
