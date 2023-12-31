package com.crud.ServiceClaasesoFMicroserices;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String username;
	
	private String password;
	
	private List<String> roles;

}
