package com.orive.Accounts.Entity;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account_list")
public class AccountListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountListId;	
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "account_holder_name")
	private String accountHolderName;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "routing_number")
	private Long routingNumber;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "email_system")
	private String emailSystem;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "access_level")
	private String accessLevel;
	
	@Column(name = "additional_account_type")
	private String additionalAccountType;
	
	@Column(name = "additional_account_information")
	private String additionalAccountInformation;
	
	@Column(name = "comments")
	private String comments;
}
