package com.orive.Organisation.Entity;

import java.util.List;

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
@Table(name = "policies")
public class PoliciesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policiesId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private List<String> description;
}
