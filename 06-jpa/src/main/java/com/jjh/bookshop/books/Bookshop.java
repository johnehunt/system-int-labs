package com.jjh.bookshop.books;

import java.sql.SQLException;
import java.util.List;

public class Bookshop {

    private BookDAO dao = new BookDAO();

    public Bookshop() {
        dao.setup();
    }

    public List<Book> getBooks() throws SQLException {
        System.out.println("Bookshop.getBooks");
        return dao.getAllBooks();
    }

    public void saveBook(Book book) {
        System.out.println("Bookshop.saveBook(" + book + ")");
        dao.saveBook(book);
    }

    public void deleteBook(Book book) {
        System.out.println("Bookshop.deleteBooks");
        dao.deleteBook(book);
    }

    public Book getBookByISBN(int isbn) {
        return dao.getBookByISBN(isbn);
    }
}
