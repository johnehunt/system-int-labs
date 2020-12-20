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
        System.out.println("BookDAO.setup()");
        try {
            conn = DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getBookByISBN(int isbn) throws SQLException {
        System.out.printf("BookDAO.getBookByISBN(%s)\n", isbn);
        Book book = null;
        String sql = String.format("SELECT * FROM books WHERE isbn = %d", isbn);
        System.out.println(sql);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            String title = rs.getString("title");
            String category = rs.getString("category");
            String author = rs.getString("author");
            book = new Book(isbn, title, category, author);
        }
        return book;
    }

    public List<Book> getBooks() throws SQLException {

        System.out.println("BookDAO.getBooks()");
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";
        System.out.println(sql);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

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
        System.out.printf("BookDAO.saveBook(%s)\n", book);

        String sql = String.format(
                "INSERT INTO books (isbn, title, category, author) VALUES(%d, '%s', '%s', '%s')",
                book.getIsbn(),
                book.getTitle(),
                book.getCategory(),
                book.getAuthor());

        System.out.println(sql);

        Statement st = conn.createStatement();
        return st.executeUpdate(sql);
    }

    public int deleteBook(Book book) throws SQLException {
        System.out.printf("BookDAO.deleteBook(%s)\n", book);
        String sql = "DELETE FROM books WHERE isbn = '" + book.getIsbn() + "'";
        System.out.println(sql);
        Statement st = conn.createStatement();
        return st.executeUpdate(sql);
    }


}
