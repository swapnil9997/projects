package com.swr.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlanJourney {
	String source;
	String destination;
	int trainNo;
	LocalDate journeyDate;
	String reservationType;
	String quota;
	double amount;

}
