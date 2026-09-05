package com.Mr_Chai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mr_Chai.Entity.Product;
import com.Mr_Chai.Service.ProductServiceInterface;

@CrossOrigin(
	    origins = "http://127.0.0.1:5500",
	    allowCredentials = "true")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceInterface productService;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/product")
	public String addProduct(@RequestBody Product product) {
		if (productService.addProduct(product) != null) {
			return "Product added successfully";
		}
		
		return "Product added failed";
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
}
