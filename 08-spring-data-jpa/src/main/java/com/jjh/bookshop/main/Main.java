package com.jjh.bookshop.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jjh.bookshop.config")
public class Main {
    public static void main(String[] args) {
        System.out.print(("Main - Starting the application"));

        SpringApplication app = new SpringApplication(Main.class);
        app.setAdditionalProfiles("dev");
        ConfigurableApplicationContext ctx = app.run(args);

        System.out.println("Main - Server Started");
        System.out.println("\tSee - http://localhost:8080/books/list");
        System.out.println("\tSee - http://localhost:8080/books/Java%20and%20Spring");
    }
}
