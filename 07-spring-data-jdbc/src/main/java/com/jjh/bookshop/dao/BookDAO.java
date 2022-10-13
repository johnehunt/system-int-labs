package com.jjh.bookshop.dao;

import com.jjh.bookshop.domain.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();

    void addBook(Book book);

    void deleteBook(Book book);
}
