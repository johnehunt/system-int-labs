package com.jjh.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookshopApp extends SpringBootServletInitializer {

    public static void main(String[] args)  {
        System.out.println("Starting App setup");
        SpringApplication.run(BookshopApp.class, args);
        System.out.println("Setup finished");
    }

}
