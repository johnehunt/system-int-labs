package com.jjh.bookshop.books;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

    @Id
    private int isbn;
    private String title;
    private String category;
    private String author;

    public Book() {}  // Required by JPA

    public Book(int isbn, String title, String category, String author) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int id) {
        this.isbn = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}


