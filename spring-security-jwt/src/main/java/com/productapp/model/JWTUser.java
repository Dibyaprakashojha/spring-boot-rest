package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
public class JWTUser {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(unique = true)
    private String username;
    private String password;

    public JWTUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
