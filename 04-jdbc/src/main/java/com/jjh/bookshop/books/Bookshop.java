package com.jjh.bookshop.books;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class Bookshop {

    private BookDAO dao = new BookDAO();

    public Bookshop() {
        dao.setuo();
    }

    public List<Book> getBooks() throws SQLException {
        System.out.println("Bookshop.getBooks");
        return dao.getAllBooks();
    }

    public int saveBook(Book book) throws SQLException {
        System.out.println("Bookshop.saveBook(" + book + ")");
        return dao.saveBook(book);
    }

    public void deleteBook(Book book) throws SQLException {
        System.out.println("Bookshop.deleteBooks");
        dao.deleteBook(book);
    }

    public Book getBookByISBN(int isbn) throws SQLException {
        return dao.getBookByISBN(isbn);
    }
}
