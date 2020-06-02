package com.jjh.books;

import java.util.List;
import java.util.stream.Collectors;

public class BookshopApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Java Bookshop");

		Bookshop bookshop = new Bookshop();

		for (Book book : bookshop.getBooks()) {
			System.out.println("Book: " + book);
		}

		bookshop.getBooks().stream().forEach(b -> System.out.println(b));

		if (bookshop.getBooks().size() > 0) {
			Book book1 = bookshop.getBooks().get(0);
			book1.setSaleDiscount(10.0);
			System.out.println("Sale price of book: " + book1.calculateSalePrice());
			book1.getAuthor().prettyPrint();
			book1.getPublisher().prettyPrint();
		}

		if (bookshop.getBooks().size() > 1) {
			Sales salesProduct = bookshop.getBooks().get(1);
			salesProduct.setSaleDiscount(10.0);
			System.out.println("Sale price of book: " + salesProduct.calculateSalePrice());
		}

		List<Book> expensiveBooks = bookshop.getBooks().stream().filter(b -> b.getPrice() > 13.00).collect(Collectors.toList());
		System.out.println(expensiveBooks);


	}

}
