package com.bookapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private Integer bookId;
    private String title;
    private String author;
    private String category;
    private double price;
}
