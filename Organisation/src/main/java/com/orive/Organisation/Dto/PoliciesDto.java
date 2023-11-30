package com.orive.Organisation.Dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
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
public class PoliciesDto {

	
    private Long policiesId;
	private String companyName;
	private String title;
	private String description;
	private Date createdDate;
	private String uploadPdf;
//	private String status;
//	private String approvedBy;
}
