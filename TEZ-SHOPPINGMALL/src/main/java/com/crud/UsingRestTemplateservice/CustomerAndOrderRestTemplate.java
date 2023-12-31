package com.crud.UsingRestTemplateservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crud.ServiceClaasesoFMicroserices.Cust_And_Order;
import com.crud.ServiceClaasesoFMicroserices.UserOrders;


@Service
@RefreshScope
public class CustomerAndOrderRestTemplate {

	@Autowired
	@Lazy
	private RestTemplate template;
	
	private String url="http://localhost:8084/customerLogin";
	
	private String url1="http://localhost:8084/customerLogin/deleteCustomerInfo/";
	
	private String url2="http://localhost:8084/customerLogin/demo";
	
//	@Value("${microservice.tez-orderservice.endpoints.endpoint.uri}")
//	private String url2;
	
	public ResponseEntity<String> deleteCustomer(long id) {
		 return template.exchange(url1+id, HttpMethod.DELETE, null, String.class);
	}
	
	public ResponseEntity<List<Cust_And_Order>> getUserInfoWithOrder(long number){
		ParameterizedTypeReference<List<Cust_And_Order>>responseType=new ParameterizedTypeReference<List<Cust_And_Order>>() {
		};
		return template.exchange(url+"/getUserOrderDetails/"+number, HttpMethod.GET, null, responseType);
	}
	
	public ResponseEntity<List<UserOrders>> getAllUsersOrders(){
		ParameterizedTypeReference<List<UserOrders>>responseType=new ParameterizedTypeReference<List<UserOrders>>() {
		};
		
		return template.exchange(url+"/getAllOrderDetails",HttpMethod.GET,null,responseType);
	}
	
	public ResponseEntity<String> getDemo(){
		
		return template.exchange(url2,HttpMethod.GET,null,String.class);
	}
}
