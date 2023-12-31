package com.crud.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/shoppingmallFallBackMethod")
	public String shoppingMall() {
		return "SHOPPING MALL SERVICE IS DOWN TRY AFTER SOME TIME";
	}
	
	@RequestMapping("/productsFallBackMethod")
	public String products() {
		return "PRODUCTS SERVICE IS DOWN TRY AFTER SOME TIME";
	}
	
	@RequestMapping("/productsRatingFallBackMethod")
	public String productsRating() {
		return "PRODUCTS RATING SERVICE IS DOWN TRY AFTER SOME TIME";
	}
	
	@RequestMapping("/ordersFallBackMethod")
	public String orders() {
		return "ORDER SERVICE IS DOWN TRY AFTER SOME TIME";
	}
}
