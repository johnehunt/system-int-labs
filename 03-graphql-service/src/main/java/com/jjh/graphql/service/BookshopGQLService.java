package com.jjh.graphql.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookshopGQLService extends SpringBootServletInitializer {

	public static void main(String[] args)  {
		System.out.println("Starting App setup");
		SpringApplication.run(BookshopGQLService.class, args);
		System.out.println("Setup finished");
		System.out.println("\tAccess: http://localhost:8080/graphiql");
	}

}