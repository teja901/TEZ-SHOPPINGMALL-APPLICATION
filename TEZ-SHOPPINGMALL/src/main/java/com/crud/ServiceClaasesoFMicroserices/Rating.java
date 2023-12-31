package com.crud.ServiceClaasesoFMicroserices;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {


	private String productName;
	
	private double rating;
	
	private String reviews;
	
}
