package com.productapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class ProductBrandView {
        @Id
        @Column(name = "productid")
        private Integer productId;
        private String name;
        private double price;
        private String brand;
}
