package com.productapp.repository;

import com.productapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(String category);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByBrandStartingWith(String brand);
    @Query("from Product p where p.category like ?1 or p.brand like ?1")
	List<Product> findByChoice(String choice);
}
