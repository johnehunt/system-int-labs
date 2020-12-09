package com.jjh.graphql.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Bookshop {
	private List<Book> books = new ArrayList<>();

	public Bookshop() {
		books.add(new Book("121", "Java", "Technical", "John Smith"));
		books.add(new Book("345", "Death in the Spring", "Detective", "Denise Jones"));
		books.add(new Book("987", "Henry VI", "Historical", "Phoebe Davies"));
	}

	public List<Book> getBooks(int count) {
		System.out.println("BookDao.getBooks");
		return books.stream().limit(count).collect(Collectors.toList());
	}

	public List<Book> getAllBooks() {
		return books;
	}

}
