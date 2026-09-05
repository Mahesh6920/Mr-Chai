package com.Mr_Chai.Service;

import java.util.List;

import com.Mr_Chai.Entity.Product;

public interface ProductServiceInterface {

	List<Product> getAllProducts();

	String addProduct(Product product);

	Product getProductById(int id);

}
