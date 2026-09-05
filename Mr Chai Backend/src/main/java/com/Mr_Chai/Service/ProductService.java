package com.Mr_Chai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mr_Chai.Entity.Product;
import com.Mr_Chai.Repository.ProductRepo;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public String addProduct(Product product) {
		if (productRepo.save(product) != null) {
			return "Product added successfully";
		} 
		
		return "Product not added";
	}

	@Override
	public Product getProductById(int id) {
		return productRepo.findById(id).orElseThrow(() -> {
			throw new RuntimeException("Product not found with id: " + id);
		});
	}

}
