package com.athena.pharamacystore.dto;

import lombok.Data;

@Data
public class DrugInfo {
	private int drugNo;
	private String drugName;
	private String genericName;
	private String manufacturer;
	private int expiryMonth;
	private int expiryYear;
	private int quantity;
	private double price;

}
