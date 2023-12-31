package com.crud.ServiceClaasesoFMicroserices;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products_Duplicate_Withoud_Id {

	private String productName;
	private String productBrandName;
	private BigDecimal productPrice;
	
	public Products_Duplicate_Withoud_Id(Products pro) {
		this.productName=pro.getProductName();
		this.productBrandName=pro.getProductBrandName();
		this.productPrice=pro.getProductPrice();
	}
}

