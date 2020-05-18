package com.jjh.books;

public class Book extends Product {
	
	// Declare Static variables
	
	private static int count;

	// Declare Instance Variables 
	
	private Author author;
	private Publisher publisher;

	public Book() {}

	public Book(String title, Author author, Publisher publisher, double price) {
		super(title, price);
		this.author = author;
		this.publisher = publisher;
		incrementBookCount();
	}
	
	// Define static methods
	
	private static void incrementBookCount() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}

	// Define instance methods
	
	@Override
	public void printer() {
		System.out.println("Book - printer");
	}
	
	// Declare getter and setter methods
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		String result = "Book[" + super.toString();
		result = result + String.format(", author=%s, publisher=%s]", author, publisher);
		return result;
	}

}
