package com.orive.Organisation.Dto;

import java.util.List;

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
	private String purchaseDate;
	private Long amount;
	private String purchaseBy;
	//private byte[] billCopy;
	private List<String> remarks;
}
