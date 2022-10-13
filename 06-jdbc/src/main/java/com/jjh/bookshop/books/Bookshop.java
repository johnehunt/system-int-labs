package com.jjh.bookshop.books;

import java.sql.SQLException;
import java.util.List;

public class Bookshop {

    private BookDAO dao = new BookDAO();

    public Bookshop() {
        dao.setup();
    }

    public void shutdown() {
        dao.shutdown();
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
        System.out.println("Bookshop.deleteBook()");
        dao.deleteBook(book);
    }

    public Book getBookByISBN(int isbn) throws SQLException {
        System.out.println("Bookshop.getBookByISBN()");
        return dao.getBookByISBN(isbn);
    }
}
