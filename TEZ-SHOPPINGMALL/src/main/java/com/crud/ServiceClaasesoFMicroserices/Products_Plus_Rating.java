package com.crud.ServiceClaasesoFMicroserices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products_Plus_Rating {
	private Products product;
	private Product_Rating rating;
	
	
	
	public Products_Plus_Rating(Product_Rating rating) {
		this.rating=rating;
		
	}
	public Products_Plus_Rating(Products product) {
		this.product=product;
	}
	
	@Override
	public String toString() {
		return "Products_Plus_Rating [product=" + product + ", rating=" + rating + "]";
	}
	
}
