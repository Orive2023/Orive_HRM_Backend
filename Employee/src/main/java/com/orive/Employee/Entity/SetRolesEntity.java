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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "set_roles")
public class SetRolesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rolesId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "access")
	private String access;
}
