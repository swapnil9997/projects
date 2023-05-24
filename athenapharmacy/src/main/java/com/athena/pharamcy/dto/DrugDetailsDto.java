package com.athena.pharamcy.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrugDetailsDto implements Serializable {
	private static final long serialVersionUID = 3603588331712854276L;
	private int drugNo;
	private String drugName;
	private String genericName;
	private String manufacturer;
	private int expiryMonth;
	private int expiryYear;
	private int quantity;
	private double price;
	public DrugDetailsDto(int drugNo, String drugName, String genericName, String manufacturer, int expiryMonth,
			int expiryYear, int quantity, double price) {
		super();
		this.drugNo = drugNo;
		this.drugName = drugName;
		this.genericName = genericName;
		this.manufacturer = manufacturer;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.quantity = quantity;
		this.price = price;
	}
	public DrugDetailsDto() {
		super();
	}
	public int getDrugNo() {
		return drugNo;
	}
	public void setDrugNo(int drugNo) {
		this.drugNo = drugNo;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DrugDetailsDto [drugNo=" + drugNo + ", drugName=" + drugName + ", genericName=" + genericName
				+ ", manufacturer=" + manufacturer + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	
}
