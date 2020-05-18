package com.jjh.shop;

import com.jjh.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BookServiceDelegate {

	public static final String USER_SERVICE_URL = "http://book-service";
	// public static final String USER_SERVICE_URL = "http://localhost:2222";

	@Autowired 
	@LoadBalanced 
	private RestTemplate restTemplate;

	public List<Book> getBooks() {
		System.out.println("BookServiceDelegate.getBooks()");
		System.out.println(USER_SERVICE_URL);
		List<Book> results = (List<Book>) restTemplate.getForObject(USER_SERVICE_URL + "/bookshop/list", List.class);
		return results;
	}

}
