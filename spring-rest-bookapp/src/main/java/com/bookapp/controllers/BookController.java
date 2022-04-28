package com.bookapp.controllers;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    public List<Book> showBooks() {
        return bookService.getAll();
    }

    // http://localhost:8080/books/author/Awadhesh
    @GetMapping("/books/author/{myauthor}")
    public List<Book> showByAuthor(@PathVariable("myauthor") String author) {
        return bookService.getByAuthor(author);
    }

    // http://localhost:8080/books/category?category=Educational -- assuming this comes from a form
    @GetMapping("/books/category")
    public List<Book> showByCategory(@RequestParam("category") String category) {
        return bookService.getByCategory(category);
    }

    // http://localhost:8080/books/price/1000
    @GetMapping("/books/price/{cost}")
    public List<Book> showByLesserPrice(@PathVariable("cost") double price) {
        return bookService.getByLesserPrice(price);
    }

    // http://localhost:8080/books/id/1
    @GetMapping("/books/id/{bookId}")
    public Book showById(@PathVariable("bookId") int id) {
        return bookService.getById(id);
    }
}
