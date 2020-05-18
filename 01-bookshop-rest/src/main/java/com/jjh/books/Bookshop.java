package com.jjh.books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bookshop {

    private List<Book> books = new ArrayList<>();

    public Bookshop() {
        setup();
    }

    private void setup() {
        Address authorAddress = new Address(10, "High Street", "Any Town", "Somerset", "SA1 23Z");
        Author author = new Author("Pete Smith", authorAddress);

        Address publisherAddress = new Address(1, "Main Street", "Some City", "Kent", "KA1 43A");
        Publisher publisher = new Publisher("Tech Books Publishing Ltd.", publisherAddress);

        Book book = new Book("Java Unleashed", author, publisher, 15.95);
        System.out.println("Book: " + book);
        this.books.add(book);

        System.out.println("\nCalculating the Sales Discount price");
        book.setSaleDiscount(10.0);
        System.out.println("Sale price of book: " + book.calculateSalePrice());

        try {
            Book book2 = new Book("Java For Professionals", author, publisher, 12.55);
            System.out.println("\nBook2: " + book2);

            System.out.println("Book Instance Count: " + Book.getCount());

            this.books.add(book2);
        } catch (BookException exp) {
            exp.printStackTrace();
        }

    }

    public List<Book> getBooks() {
        return this.books;
    }

    public Book getBookByTitle(String title) {
        System.out.println("Bookshop.getBook(" + title + ")");
        List<Book> books = this.books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if (books.size() > 0)
            return books.get(0);
        else
            return null;
    }

    public void addBook(Book book) {
        System.out.println("Bookshop.addBook(" + book + ")");
        if (!this.books.contains(book)) {
            this.books.add(book);
        }
    }

    public void updateBook(Book newVersionOfBook) {
        System.out.println("Bookshop.updateBook(" + newVersionOfBook + ")");
        Book originalBook = this.getBookByTitle(newVersionOfBook.getTitle());
        if (originalBook == null)
            throw new BookException("Book with title: " + newVersionOfBook.getTitle() + " not found");
        originalBook.setAuthor(newVersionOfBook.getAuthor());
        originalBook.setPrice(newVersionOfBook.getPrice());
    }

    public void deleteBook(String title) {
        System.out.println("Bookshop.deleteBook(" + title + ")");
        Book book = this.getBookByTitle(title);
        if (book != null)
            this.books.remove(book);
        else
            throw new BookException("Book with title: " + title + " not found");
    }

}
