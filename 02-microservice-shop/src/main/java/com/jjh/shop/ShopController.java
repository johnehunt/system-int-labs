package com.jjh.shop;

import com.jjh.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShopController {

	@Autowired
	private BookServiceDelegate delegate;

	@GetMapping
	public Map<String, List<Book>> getBooks() {
		System.out.println("ShopService.getBooks()");
		Map<String, List<Book>> map = new HashMap<String, List<Book>>();
		map.put("Technical", this.delegate.getBooks());
		return map;
	}

}
