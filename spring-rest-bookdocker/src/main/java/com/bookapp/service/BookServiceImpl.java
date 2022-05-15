package com.bookapp.service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements IBookService{

    @Override
    public Book getById(int bookId) {
        return showBooks().stream().filter(book -> book.getBookId()==bookId).findAny().orElseThrow(IdNotFoundException::new);
    }

    @Override
    public List<Book> getAll() {
        return showBooks();
    }

    @Override
    public List<Book> getByAuthor(String author) {
        List<Book> booksByAuthor = showBooks().stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
        if(booksByAuthor.isEmpty())
            throw new BookNotFoundException("Books by "+author+"author is not found");
        return showBooks().stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getByCategory(String category) {
        List<Book> booksByCategory = showBooks().stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());

        if(booksByCategory.isEmpty())
            throw new BookNotFoundException("Books by "+category+"category is not found");

        return showBooks().stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());

    }

    @Override
    public List<Book> getByLesserPrice(double price) {
        return showBooks().stream().filter(book -> book.getPrice()<=price).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());

    }

    private List<Book> showBooks() {
        return Arrays.asList(
                new Book(1,"Java", "Awadesh","Educational", 120.00),
                new Book(2,"HTML", "Madhu","Tech", 100.00),
                new Book(3,"JavaScript", "Awadesh","Educational", 95.00),
                new Book(4,"CSS", "Shravani","Tech", 150.00),
                new Book(5,"NodeJs", "Abuthair","Educational", 100.00),
                new Book(6,"Spring", "Abuthair","Educational", 450.00)
        );
    }
}
