package com.crud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TezOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TezOrderServiceApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void show() {
//		System.out.println("Hi>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	}
}
