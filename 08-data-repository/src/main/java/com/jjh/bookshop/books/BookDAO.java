package com.jjh.bookshop.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDAO {

    @Autowired
    private BookRepository repo;


    public Book getBookByISBN(int isbn) {
        System.out.printf("BookDAO.getBookByISBN(%s)\n", isbn);
        return repo.findById(isbn).orElseGet(null);
    }

    public Iterable<Book> getAllBooks() {
        System.out.println("BookDAO.getAllBooks()");
        return repo.findAll();
    }

    public void saveBook(Book book) {
        System.out.printf("BookDAO.saveBook(%s)\n", book);
        repo.save(book);
    }

    public void deleteBook(Book book) {
        System.out.printf("BookDAO.deleteBook(%s)\n", book);
        repo.delete(book);
    }
}
