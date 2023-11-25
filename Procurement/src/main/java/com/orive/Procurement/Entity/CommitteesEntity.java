package com.orive.Procurement.Entity;

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
@Table(name = "committees")
public class CommitteesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long committeesId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "signature")
	private String signature;

}
