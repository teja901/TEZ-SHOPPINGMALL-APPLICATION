package com.crud.Entity;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Rating {

	
	private Long id;
	private String productName;
	private Double rating;
	private List<String> reviews;
	private Long no_Of_People_Rated;
	
	public Product_Rating(String name) {
		
	}
	
}

