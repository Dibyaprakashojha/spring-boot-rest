package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

import java.util.List;

public interface IProductService {
	void addProduct(Product product);
	void deleteProduct(int productId);
	void updateProduct(Product product);
	List<Product> getAll();
	Product getById(int productId);
	
	List<Product> getByCategory(String category) throws ProductNotFoundException;
    List<Product> getByChoice(String choice) throws ProductNotFoundException;
    List<Product> getByPriceLessThan(double price);
    List<Product> getByBrandStartingWith(String brand) throws ProductNotFoundException;
}
