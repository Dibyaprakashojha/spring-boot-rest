package com.productapp.repository;

import com.productapp.model.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JWTUserRepository extends JpaRepository<JWTUser,Integer> {
    JWTUser findByUsername(String username);
}
