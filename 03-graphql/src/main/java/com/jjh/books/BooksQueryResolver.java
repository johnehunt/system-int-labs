package com.jjh.books;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class BooksQueryResolver implements GraphQLQueryResolver {
    private Bookshop bookshop = new Bookshop();

    public List<Book> getBooks(int count) {
        System.out.println("Query.getBooks(" + count + ")");
        return bookshop.getBooks(count);
    }
}
