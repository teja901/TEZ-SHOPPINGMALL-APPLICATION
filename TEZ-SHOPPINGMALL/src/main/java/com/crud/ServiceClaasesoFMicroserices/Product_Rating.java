package com.crud.ServiceClaasesoFMicroserices;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Rating {

	private String productName;
	private Double rating;
	private List<String> reviews=new ArrayList<>();
	private Long no_Of_People_Rated;
}
