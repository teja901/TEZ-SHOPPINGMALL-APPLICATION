package com.crud.UserInfoRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.ServiceClaasesoFMicroserices.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long>{
	
	public Optional<UserInfo> findByusername(String name);

}
