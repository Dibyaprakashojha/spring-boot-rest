package com.productapp.model;
import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class ProductView {
        @Id
        @Column(name = "productid")
        private Integer productId;
        private String name;
        private String brand;
        private double price;
}
