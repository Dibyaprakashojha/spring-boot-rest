package com.productapp.repository;

import com.productapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IProductViewRepository extends JpaRepository<ProductView, Integer>{

    // from view
}
