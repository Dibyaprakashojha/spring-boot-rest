package com.tutorapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "subcategory")
public class SubCategory {
    @Id
    @GeneratedValue(generator = "subcategory_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "subcategory_gen",sequenceName = "subcategory_seq",initialValue = 1,allocationSize = 1)
    @ToString.Exclude
    private Integer subCategoryId;
    @Column(length = 40)
    private String subcategoryName;
    private String topic; // HTML5, React, CSS, Spring, Python

    public SubCategory(String subcategoryName, String topic) {
        this.subcategoryName = subcategoryName;
        this.topic = topic;
    }
}
