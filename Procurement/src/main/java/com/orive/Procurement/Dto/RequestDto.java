package com.orive.Procurement.Dto;

import java.util.List;



import jakarta.persistence.Column;
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
public class RequestDto {

    private Long requestId;
	private String requestingPerson;
	private String requestingDepartment;
	private String expectedTimeToHaveTheGoodStarts;
	private String expectedTimeToHaveTheGoodEnds;
	private String reasonForRequesting;
	private List<DescriptionOfMaterialDto> descriptionOfMaterialDtos;
}
