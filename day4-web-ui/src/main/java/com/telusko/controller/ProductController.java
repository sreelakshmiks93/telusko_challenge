package com.telusko.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Product;
import com.telusko.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping("/products")
	public Object getAllProducts(){
		Map<String, Object> map = new HashMap<>();
		List<Product> list =  service.getAllProducts();
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/products/warrantyexpired")
	public Object getAllProductsOutOfWarranty(){
		Map<String, Object> map = new HashMap<>();
		List<Product> list =  service.findProductsOutOfWarranty();
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/products/place")
	public Object getAllProductsByPlace(@RequestParam String place){
		Map<String, Object> map = new HashMap<>();
		List<Product> list =  service.searchByPlace(place);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/products/searchtext")
	public Object getAllProductsByText(@RequestParam String text){
		Map<String, Object> map = new HashMap<>();
		List<Product> list =  service.getProductWithText(text);
		map.put("data", list);
		return map;
	}
	
	@PostMapping("/product")
	public Object addProduct(@RequestBody Product product){
		Map<String, Object> map = new HashMap<>();
		try {
		if(product.getName() == null || "".equals(product.getName()) ) {
			map.put("status", 400);
			map.put("error", "Name is mandatory");
		}else {
			service.addProduct(product);
			map.put("status", 200);
		}
		}catch(Exception e) {
			map.put("status", 400);
			map.put("error", e.getMessage());
		}
		return map;
	}
}
