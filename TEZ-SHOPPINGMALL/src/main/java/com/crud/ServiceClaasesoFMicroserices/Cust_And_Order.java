package com.crud.ServiceClaasesoFMicroserices;
import java.util.UUID;

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
