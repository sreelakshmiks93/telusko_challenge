package com.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.ProductDB;
import com.telusko.model.Product;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDB db;

    public void addProduct(Product p){
       // products.add(p);

        db.save(p);

    }

    public List<Product> getAllProducts(){

        return db.findAllByOrderByIdDesc();
    }
//
//    public Product getProduct(String name){
//        for(Product p : products){
//            if(p.getName().equals(name))
//                return p;
//        }
//
//        return null;
//    }

	public Product getProduct(String string) {
		return db.findByName(string);
	}

	public List<Product> getProductWithText(String string) {
		List<Product> products = db.findByNameContainsIgnoreCaseOrPlaceContainsIgnoreCaseOrTypeContainsIgnoreCase(string, string, string);
		return products;
	}

	public List<Product> searchByPlace(String string) {
		return db.findByPlaceIgnoreCase(string);
	}

	public List<Product> findProductsOutOfWarranty() {
		int year = Year.now().getValue();
		List<Product> products = db.findByWarrantyLessThan(year);
		return products;
	}


}
