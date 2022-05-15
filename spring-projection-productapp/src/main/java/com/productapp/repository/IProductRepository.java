package com.productapp.repository;

import com.productapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;


public interface IProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(String category);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByBrandStartingWith(String brand);
    @Query("from Product p where p.category like ?1 or p.brand like ?1")
	List<Product> findByChoice(String choice);

    List<BrandDTO> findByBrand(String brand);

    // get the product name, brand for the category and price less than

    @Query("select new com.productapp.model.CategoryDTO(name,brand) from Product p where p.category=?1 and p.price<=?2")
    List<CategoryDTO> findByCategoryAndPrice(String category, double price);

    // select the product name and get the product details not complete product
    ProductDetails findByName(String name);

    // open projections
    List<ProductDetailsEx> getByBrand(String brand);


    // stored procedure use @Procedure
    // use the same procedure name as method name in CAPS

//    @Procedure
//    List<Product> SHOW_PRODUCTS();

    // have a different method name and pass the procedure name as attribute
    @Procedure(procedureName="SHOW_PRODUCT")
//  @Procedure(value="SHOW_PRODUCTS")
    List<Product> readAllProducts();

    @Procedure(procedureName = "SHOW_BY_BRAND")
    List<Product> readByBrand(String brand);

    @Procedure("SUM_OF_BRANDS")
    double getTotalCost(String brand);
}
