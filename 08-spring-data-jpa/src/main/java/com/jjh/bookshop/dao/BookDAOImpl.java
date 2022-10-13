package com.jjh.bookshop.dao;

import com.jjh.bookshop.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("InMemoryBookDAO")
public class BookDAOImpl implements BookDAO {

    private final List<Book> books = new ArrayList<>();

    public BookDAOImpl() {
        Book b1 = new Book("123", "Java and Spring", "John Smith", "Tech Books", 12.99);
        Book b2 = new Book("124", "Java for Professionals", "Adam Young", "Tech Books", 15.95);
        books.add(b1);
        books.add(b2);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(Book book) {
        books.remove(book);
    }

}
