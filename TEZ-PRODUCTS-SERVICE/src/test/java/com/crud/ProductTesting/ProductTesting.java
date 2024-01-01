package com.crud.ProductTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.crud.Entity.Products;

@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductTesting {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate ts;
	
	
	@Test
	public void testSave() {
		
		Products pro=new Products();
		pro.setProductBrandName("VIVO");
		pro.setProductName("VIVOY9");
		pro.setProductPrice(new BigDecimal(20000));
		pro.setProductsLeft(4L);
	
		
		ResponseEntity<ProductTesting> rs=ts.postForEntity("http://localhost:"+port+"/products/save",
				new HttpEntity<>(pro), ProductTesting.class);
		
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		System.out.println(rs.getBody());
					}
	
	
	@Test
	public void getProductTest() {
		
		String productName="VIVOY9";
		ResponseEntity<ProductTesting> rs=ts.getForEntity(
				"http://localhost:"+port+"/products"+"/get/"
				+productName,ProductTesting.class
				);
	}
	

	@Test
	public void updateProduct() {
		String productName="VIVOY9";

		
		Products pro=new Products();
		
		pro.setProductBrandName("VIVO");
		pro.setProductName("VIVOY9");
		pro.setProductPrice(new BigDecimal(20000));
		pro.setProductsLeft(4L);
		
		ResponseEntity<ProductTesting> rs=ts.exchange("http://localhost:"+port+"/products/update/"+productName,
				HttpMethod.PUT, new HttpEntity<>(pro), ProductTesting.class);
				
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		
	
	}
	
	@Test
	public void deleteProduct() {
		long id=702L;
		
		
		ResponseEntity<String> rs=ts.exchange("http://localhost:"+port+"/products/deleteid/"+id,
				HttpMethod.DELETE,null,String.class);
				
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		
	
	}
	
}
