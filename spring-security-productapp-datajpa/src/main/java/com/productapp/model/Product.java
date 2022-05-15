package com.productapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {
	@Id
	@Column(name = "productid")
	@GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen",sequenceName = "product_sequence",initialValue = 100,allocationSize = 1)
	private Integer productId;
	private String name;
	private String brand;
	private String category;
	private double price;
}
