package com.orive.Organisation.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.orive.Organisation.Entity.ExpenceEntity;
import com.orive.Organisation.Entity.ExpenseListEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class ExpenceDto {

	
	private Long expenceId;
	
	
	private String expenceType;
	
	
	private Date createdDate;
	
	
	private Long total;
	
//	@Column(name = "status")
//	private String status;
//	
//	@Column(name = "approved_by")
//	private String approvedBy;
	
	
	private List<ExpenseListDto> expenseListEntities;
}
