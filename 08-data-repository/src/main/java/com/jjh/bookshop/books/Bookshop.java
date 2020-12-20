package com.jjh.bookshop.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bookshop {

    @Autowired
    private BookDAO repo;

    public List<Book> getBooks() {
        System.out.println("Bookshop.getBooks");
        Iterable<Book> iterable = repo.getAllBooks();
        List<Book> books = new ArrayList<Book>();
        for (Book b : iterable) {
            books.add(b);
        }
        return books;
    }

    public void saveBook(Book book) {
        System.out.println("Bookshop.saveBook(" + book + ")");
        repo.saveBook(book);
    }

    public void deleteBook(Book book) {
        System.out.println("Bookshop.deleteBooks");
        repo.deleteBook(book);
    }

    public Book getBookByISBN(int isbn) {
        return repo.getBookByISBN(isbn);
    }
}
