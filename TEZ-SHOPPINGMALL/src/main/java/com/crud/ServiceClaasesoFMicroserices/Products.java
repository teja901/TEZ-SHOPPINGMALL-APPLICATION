package com.crud.ServiceClaasesoFMicroserices;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

	private Long productId;
	private String productName;
	private String productBrandName;
	private BigDecimal productPrice;
	
	
}
