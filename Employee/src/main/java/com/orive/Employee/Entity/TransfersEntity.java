package com.orive.Employee.Entity;

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
@Table(name = "transfers")
public class TransfersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transferId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "transfer_date")
	private String transferDate;
	
	@Column(name = "Transfer_to_department")
	private String TransferToDepartment;
	
	@Column(name = "transfer_to_location")
	private String transferToLocation;
}
