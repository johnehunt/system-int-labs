package com.jjh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookshopServiceApplication {

    public static void main(String[] args) {
        System.out.println("========================");
        System.out.println(("Starting Spring Boot"));
        System.out.println("========================");
        SpringApplication.run(BookshopServiceApplication.class, args);
        System.out.println("========================");
        System.out.println("Done");
        System.out.println("========================");
    }
}