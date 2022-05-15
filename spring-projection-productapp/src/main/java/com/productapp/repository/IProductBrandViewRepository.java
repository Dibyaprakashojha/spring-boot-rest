package com.productapp.repository;

import com.productapp.model.ProductBrandView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IProductBrandViewRepository extends JpaRepository<ProductBrandView, Integer>{

    List<ProductBrandView> findByBrand(String brand);
}
