package com.swr.dto;

import lombok.Data;

@Data
public class Ticket {
	String pnrNO;
	String source;
	String destination;
	String[] berthAlloted;
	String status;
	String coach;

}