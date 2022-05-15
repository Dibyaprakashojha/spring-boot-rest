package com.bookapp.service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    Book getById(int bookId) throws IdNotFoundException;
    List<Book> getAll();
    List<Book> getByAuthor(String author) throws BookNotFoundException;
    List<Book> getByCategory(String category) throws BookNotFoundException;
    List<Book> getByLesserPrice(double price) throws BookNotFoundException;
}
