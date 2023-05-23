package com.telusko.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.model.Product;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

	Product findByName(String string);


	List<Product> findByPlace(String string);

	List<Product> findByWarrantyLessThan(int year);


	List<Product> findByPlaceContainingIgnoreCase(String string);


	List<Product> findByPlaceIgnoreCase(String string);


	List<Product> findByNameContainsIgnoreCaseOrPlaceContainsIgnoreCaseOrTypeContainsIgnoreCase(String string,
			String string2, String string3);


	List<Product> findAllByOrderByIdDesc();

}
