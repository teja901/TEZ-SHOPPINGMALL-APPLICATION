package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TezshoppingmalApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TezshoppingmalApiGatewayApplication.class, args);
	}

}
