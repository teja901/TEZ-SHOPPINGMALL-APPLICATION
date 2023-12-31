package com.crud.Entity;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class Cust_And_Order {

	private UUID orderId;
	
	private String userName;
	
	private Long mobileNumber;
	
	private  String orderedProduct;
	
	private String userAddress;

	public Cust_And_Order(UUID orderId,String userName, Long mobileNumber, String orderedProduct, String userAddress) {
		super();
		this.orderId=orderId;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.orderedProduct = orderedProduct;
		this.userAddress = userAddress;
	}

	
	
	
}
