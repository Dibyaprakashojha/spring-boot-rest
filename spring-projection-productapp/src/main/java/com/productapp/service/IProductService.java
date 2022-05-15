package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.*;

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

	List<BrandDTO> getByBrand(String brand);
	List<CategoryDTO> getByCategoryAndPriceLessThan(String category, double price);
	ProductDetails getByName(String name);


	List<ProductView> getAllProducts();
	List<ProductBrandView> getByBrandProduct(String brand);


	//open projection
	List<ProductDetailsEx> findByBrand(String brand);

	// stored procedures
	List<Product> readAllProducts();
	List<Product> readByBrand(String brand);
	double getTotalCost(String brand);




}
