package com.jjh.bookshop.books;

import java.sql.SQLException;

public class BookshopApp {
    public static void main(String [] args) throws SQLException {
        Bookshop bookshop = new Bookshop();
        System.out.println(("------------------------\n"));

        System.out.println(bookshop.getBooks());
        System.out.println(("------------------------\n"));

        Book b1 = bookshop.getBookByISBN(2);
        System.out.println(b1);
        System.out.println(("------------------------\n"));

        Book b2 = new Book(7, "Java For Professionals", "Technical", "John Anders");
        bookshop.saveBook(b2);
        System.out.println(("------------------------\n"));

        System.out.println(bookshop.getBooks());
        System.out.println(("------------------------\n"));

        bookshop.deleteBook(b2);
        System.out.println(("------------------------\n"));

        System.out.println(bookshop.getBooks());

    }
}
