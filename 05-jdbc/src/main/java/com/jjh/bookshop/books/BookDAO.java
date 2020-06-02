package com.jjh.bookshop.books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String url = "jdbc:mysql://localhost/bookshop";
    private static final String user = "user";
    private static final String pwd = "user123";
    private Connection conn;

    public void setup() {
        try {
            conn = DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getBookByISBN(int isbn) throws SQLException {
        Book book = null;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM books WHERE ISBN = " + isbn);
        if (rs.next()) {
            String title = rs.getString("title");
            String category = rs.getString("category");
            String author = rs.getString("author");
            book = new Book(isbn, title, category, author);
        }
        return book;
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM books");

        while (rs.next()) {
            int isbn = rs.getInt("isbn");
            String title = rs.getString("title");
            String category = rs.getString("category");
            String author = rs.getString("author");
            books.add(new Book(isbn, title, category, author));
        }

        return books;
    }

    public int saveBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (isbn, title, category, author) VALUES('";
        sql = sql + book.getIsbn() + "', '" + book.getTitle() + "', '" + book.getCategory() + "', '" + book.getAuthor() + "')";
        System.out.println(sql);
        Statement st = conn.createStatement();
        return st.executeUpdate(sql);
    }

    public int deleteBook(Book book) throws SQLException {
        String sql = "DELETE FROM books WHERE ISBN = '" + book.getIsbn() + "'";
        System.out.println(sql);
        Statement st = conn.createStatement();
        return st.executeUpdate(sql);
    }


}
