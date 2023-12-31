package com.crud.Entity;

import java.math.BigDecimal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products_Duplicate {

	
	
	private String productName;
	private String productBrandName;
	private BigDecimal productPrice;
	private transient Product_Rating rating;
	
	@Override
	public String toString() {
		return "Products [ productName=" + productName + ", productBrandName="
				+ productBrandName + ", productPrice=" + productPrice + ", rating=" + rating + "]";
	}
	
	public String toStrings() {
		return "Products [ productName=" + productName + ", productBrandName="
				+ productBrandName + ", productPrice=" + productPrice + "]";
	}
	
	public Products_Duplicate(Products pro) {
		
		this.productBrandName=pro.getProductBrandName();
		this.productPrice=pro.getProductPrice();
		this.productName=pro.getProductName();
	}
	public Products_Duplicate(Product_Rating rating) {
		this.rating=rating;
	}
}