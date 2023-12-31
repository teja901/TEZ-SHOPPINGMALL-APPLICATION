package com.crud.OtherMicroservicesClasses;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsWithoutId {
	private String productName;
	private String productBrandName;
	private BigDecimal productPrice;
	private long quantity;
}
