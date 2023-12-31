package com.crud.SecurityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {

        http.csrf().disable()

//        
//             
//              .authorizeHttpRequests((authorize)-> authorize.requestMatchers("/tezmall/getAllUsersOrders","/tezmall/getUserOrderDetails/{number}")
//            		  .authenticated())
//              .authorizeHttpRequests((authorize)-> authorize.requestMatchers("/tezmall/**").permitAll())
//            .httpBasic(Customizer.withDefaults());
//               
//       
//               
    .authorizeHttpRequests((authorize) ->
    authorize
    .requestMatchers("/tezmall/membership/**")
    .authenticated()
    .anyRequest().permitAll())
.httpBasic(Customizer.withDefaults());

				
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new  BCryptPasswordEncoder();
	}
	
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userDetailsService());
	        provider.setPasswordEncoder(passwordEncoder());
	        return provider;
	    }
	 
	 protected void configure(AuthenticationManagerBuilder auth) {
	        auth.authenticationProvider(authenticationProvider());
	    }
}
