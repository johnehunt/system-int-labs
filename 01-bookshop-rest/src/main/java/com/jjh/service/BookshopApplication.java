package com.jjh.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookshopApplication {
    public static void main(String[] args) {
        System.out.println("Starting Bookshop Service");
        SpringApplication.run(BookshopApplication.class, args);
        System.out.println("Setup finished");
    }
}
