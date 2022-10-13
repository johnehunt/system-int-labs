package com.jjh.bookshop.dao;

import com.jjh.bookshop.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Provides a JDBC Based implementation of a
 * Book DAO.
 */
@Component("JDBCBookDAO")
public class JDBCBookDAOImpl implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getBooks() {
        String sql = "SELECT * FROM books";
        RowMapper<Book> rowMapper = new BookMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (isbn, title, author, publisher, price) values (?,?,?,?,?)";
        jdbcTemplate.update(sql,
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPrice());
    }

    @Override
    public void deleteBook(Book book) {
        String sql = "DELETE from books WHERE isbn=" + book.getIsbn();
        jdbcTemplate.update(sql);
    }
}

class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        String isbn = rs.getString("isbn");
        String title = rs.getString("title");
        String author = rs.getString("author");
        String publisher = rs.getString("publisher");
        double price = rs.getDouble("price");
        return new Book(isbn, title, author, publisher, price);
    }
}