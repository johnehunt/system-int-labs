package com.jjh.shop;

import com.jjh.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShopController {

    private static final String USER_SERVICE_URL = "http://book-service";

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;


    @GetMapping
    public Map<String, List<Book>> getBooks() {
        System.out.println("ShopService.getBooks()");
        Map<String, List<Book>> map = new HashMap<String, List<Book>>();
        List<Book> results = (List<Book>) restTemplate.getForObject(USER_SERVICE_URL + "/bookshop/list", List.class);
        map.put("Technical", results);
        return map;
    }

}
