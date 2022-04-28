package com.furnapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedQuery(name = "getCategoryCost",query = "select f.price from Furniture f where f.category=?1")
public class Furniture {
    @Id
    @GeneratedValue(generator = "furn_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "furn_gen",sequenceName = "furn_sequence",initialValue = 10,allocationSize = 1)
    private Integer furnitureId;
    @Column(length = 30)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Category category;
    private String material;
    private String roomType;
    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private Style style;
    private String brand;
    private double price;
    private boolean storageAvailable;

    public Furniture(String name, Category category,
                     String material, String roomType,
                     Style style, String brand, double price,
                     boolean storageAvailable) {
        this.name = name;
        this.category = category;
        this.material = material;
        this.roomType = roomType;
        this.style = style;
        this.brand = brand;
        this.price = price;
        this.storageAvailable = storageAvailable;
    }
}