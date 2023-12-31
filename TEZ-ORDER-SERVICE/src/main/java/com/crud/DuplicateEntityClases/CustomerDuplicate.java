package com.crud.DuplicateEntityClases;

import com.crud.Entity.CustomerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDuplicate {

	
	private String name;
	private String email;
	private Long mobileNumber;
	
	public CustomerDuplicate(CustomerDetails details) {
		
		this.name = details.getName();
		this.email = details.getEmail();
		this.mobileNumber =details.getMobileNumber();
	}

	
}
