package com.crud.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long productId;
	private String productName;
	private String productBrandName;
	private BigDecimal productPrice;
	private Long productsLeft;
	
	
	
	
	
}
