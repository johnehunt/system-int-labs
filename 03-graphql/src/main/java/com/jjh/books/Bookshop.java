package com.jjh.books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bookshop {

    private List<Book> books = new ArrayList<>();

    public Bookshop() {
        books.add(new Book("121", "Java", "Technical", "Bill Smith"));
        books.add(new Book("345", "Death in the Spring", "Detective", "John Davies"));
        books.add(new Book("987", "Henry VI", "Historical", "Alun Jones"));
    }

    public List<Book> getBooks(int count) {
        System.out.println("Bookshop.getBooks");
        return books.stream().limit(count).collect(Collectors.toList());
    }

    public void saveBook(Book book) {
        System.out.println("Bookshop.saveBook(" + book + ")");
        books.add(book);
    }

}
