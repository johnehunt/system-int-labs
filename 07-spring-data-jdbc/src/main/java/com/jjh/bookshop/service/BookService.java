package com.jjh.bookshop.service;

import com.jjh.bookshop.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    void addBook(Book book);

    void deleteBook(Book book);

    Book getBookByTitle(String title);
    void updateBook(Book newVersionOfBook);
    void deleteBook(String title);

}
