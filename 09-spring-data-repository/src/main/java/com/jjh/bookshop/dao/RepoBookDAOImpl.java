package com.jjh.bookshop.dao;

import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component("RepoBookDAO")
public class RepoBookDAOImpl implements BookDAO {

    private BookRepository repo;

    @Autowired
    public void setRepo(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> getBooks() {
        ArrayList<Book> list = new ArrayList();
        Iterable<Book> iterator = this.repo.findAll();
        iterator.forEach(list::add);
        return list;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        repo.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        repo.delete(book);
    }
}
