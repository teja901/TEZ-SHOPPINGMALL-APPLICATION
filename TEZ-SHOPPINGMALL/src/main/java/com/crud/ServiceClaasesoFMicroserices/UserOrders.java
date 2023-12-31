package com.crud.ServiceClaasesoFMicroserices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrders {

private String productName;
	
	private String address;
	
	private Long quantity;
}
