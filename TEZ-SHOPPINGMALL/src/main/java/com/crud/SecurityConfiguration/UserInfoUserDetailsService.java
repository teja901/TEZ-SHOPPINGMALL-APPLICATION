package com.crud.SecurityConfiguration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.crud.Exceptionclass.CustomerNotFound;
import com.crud.ServiceClaasesoFMicroserices.UserInfo;
import com.crud.UserInfoRepo.UserInfoRepo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	private UserInfoRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          
		Optional<UserInfo> u=repo.findByusername(username);
		u.get().setPassword( encoder.encode(u.get().getPassword()));
			return new UserInfoUserDetails(u.orElseThrow(()-> new UsernameNotFoundException("NO USER With Name Of :"+username)));
		}
	}


