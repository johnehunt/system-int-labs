package com.jjh.bookshop.domain;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

	@NotNull
	@Size(min = 4, max = 6)
	private String isbn;
	@NotNull
	private String title;
	private String author;
	@NotNull
	private String publisher;
	@NotNull
	@DecimalMin(value = "0.0")
	@DecimalMax(value="45.0")
	private double price;

	public Book() {}

	public Book(String isbn, String title, String author, String publisher, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book[author=" + author + ", isbn=" + isbn + ", price="
				+ price + ", publisher=" + publisher + ", title=" + title + "]";
	}

}
