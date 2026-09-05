package com.Mr_Chai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mr_Chai.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	Optional<Product> findById(int id);
}
