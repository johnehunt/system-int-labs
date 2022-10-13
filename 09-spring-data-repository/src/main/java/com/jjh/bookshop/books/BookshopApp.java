package com.jjh.bookshop.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jjh.bookshop", "com.jjh.service"})
public class BookshopApp {
    public static void main(String [] args)  {
        System.out.println("Starting Bookshop setup");
        ConfigurableApplicationContext context = SpringApplication.run(BookshopApp.class, args);
        System.out.println("Setup finished");

        Bookshop bookshop = context.getBean(Bookshop.class);
        System.out.println(bookshop.getBooks());

        Book b1 = bookshop.getBookByISBN(2);
        System.out.println(b1);

        Book b2 = new Book(7, "Java For Professionals", "Technical", "John Anders");
        bookshop.saveBook(b2);

        System.out.println(bookshop.getBooks());

        bookshop.deleteBook(b2);
        System.out.println(bookshop.getBooks());
    }
}
