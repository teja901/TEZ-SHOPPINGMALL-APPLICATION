package com.crud.Entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class ProductsWithoutId {

	
	private String productName;
	private String productBrandName;
	private BigDecimal productPrice;
	private long quantity;
	
	
	public ProductsWithoutId(Products pro) {
		this.productBrandName=pro.getProductBrandName();
		this.productName=pro.getProductName();
		this.productPrice=pro.getProductPrice();
		this.quantity=pro.getProductsLeft();
	}
	
	
}
	
