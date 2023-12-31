package com.crud.ServiceClaasesoFMicroserices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDuplicate {

	private String name;
	private String email;
	private Long mobileNumber;
	
}
