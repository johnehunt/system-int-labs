package com.jjh.bookshop.controller;

import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.domain.BookException;
import com.jjh.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookshopController {

    private BookService service;

    @Autowired
    public BookshopController(BookService service) {
        this.service = service;
    }

    @GetMapping("{title}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable String title) {
        System.out.println("BookshopController.getBook(" + title + ")");
        return this.service.getBookByTitle(title);
    }

    @GetMapping("list")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        System.out.println("BookshopController.getAllBooks()");
        return service.getBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@RequestBody Book book) {
        System.out.println("BookshopController.addBook(" + book + ")");
        this.service.addBook(book);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody Book book) {
        System.out.println("BookshopController.updateBook(" + book + ")");
        this.service.updateBook(book);
    }

    @DeleteMapping("{title}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable String title) {
        System.out.println("BookshopController.deleteBook(" + title + ")");
        service.deleteBook(title);
    }

    @ExceptionHandler(BookException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
    public void updateFailure() {
    }

}
