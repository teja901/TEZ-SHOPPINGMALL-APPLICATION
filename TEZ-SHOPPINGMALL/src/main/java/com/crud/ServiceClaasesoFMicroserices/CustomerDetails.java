package com.crud.ServiceClaasesoFMicroserices;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {

	
	private Long id;
	private String name;
	private String email;
	private Long mobileNumber;
	
	private List<UserOrders> orders;
}
