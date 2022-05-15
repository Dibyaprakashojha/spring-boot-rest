package com.tutorapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Category {
    @Id
    @GeneratedValue(generator = "category_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "category_gen",sequenceName = "category_seq",initialValue = 50,allocationSize = 1)
    @ToString.Exclude
    private Integer categoryId;

    @Column(length = 50)
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id") // this will be added as foreign key in SubCategory Table
    Set<SubCategory> subCategories; // programming, datascience, ai

    public Category(String categoryName, Set<SubCategory> subCategories) {
        this.categoryName = categoryName;
        this.subCategories = subCategories;
    }
}
