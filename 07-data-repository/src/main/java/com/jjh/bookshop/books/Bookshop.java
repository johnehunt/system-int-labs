package com.jjh.bookshop.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class Bookshop {

    @Autowired
    private BookRepository repo;

    public List<Book> getBooks() {
        System.out.println("Bookshop.getBooks");
        Iterable<Book> iterable = repo.findAll();
        List<Book> books = new ArrayList<Book>();
        for (Book b : iterable) {
            books.add(b);
        }
        return books;
    }

    public void saveBook(Book book) {
        System.out.println("Bookshop.saveBook(" + book + ")");
        repo.save(book);
    }

    public void deleteBook(Book book) {
        System.out.println("Bookshop.deleteBooks");
        repo.delete(book);
    }

    public Optional<Book> getBookByISBN(int isbn) {
        return repo.findById(isbn);
    }
}
