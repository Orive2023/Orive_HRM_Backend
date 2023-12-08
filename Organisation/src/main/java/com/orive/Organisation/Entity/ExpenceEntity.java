package com.orive.Organisation.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
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
@Table(name = "expence")
public class ExpenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expenceId;
	
	@Column(name = "expence_type")
	private String expenceType;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "total")
	private Long total;
	
	@Lob
	@Column(name = "upload_document", length = 100000)
	private byte[] uploadDocument;
	
//	@Column(name = "status")
//	private String status;
//	
//	@Column(name = "approved_by")
//	private String approvedBy;
	
	@OneToMany(targetEntity =ExpenseListEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "expence_list_fk",referencedColumnName = "expenceId")
	private List<ExpenseListEntity> expenseListEntities;
}
