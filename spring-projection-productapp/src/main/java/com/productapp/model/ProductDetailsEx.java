package com.productapp.model;

import org.springframework.beans.factory.annotation.Value;


// open projection
// target -> name of the entity
public interface ProductDetailsEx {
    @Value("#{target.name+' '+target.price}")
    String getProduct();
}
