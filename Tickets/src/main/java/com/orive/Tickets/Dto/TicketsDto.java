package com.orive.Tickets.Dto;

import java.util.Date;

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
public class TicketsDto {

    private Long ticketsId;
	private String ticketsCode;
	private String subject;
	private String employeeName;
	private String priority;
	private Date date;
}
