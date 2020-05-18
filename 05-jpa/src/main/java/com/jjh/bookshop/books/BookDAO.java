package com.jjh.bookshop.books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDAO {

    private EntityManager em;

    public void setuo() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookshopJPA");
        em = emf.createEntityManager();
    }

    public Book getBookByISBN(int isbn) {
        Book book = em.find(Book.class, isbn);
        return book;
    }

    public List<Book> getAllBooks() {
        String jql = "SELECT b FROM Book b";
        TypedQuery<Book> query = em.createQuery(jql, Book.class);
        List<Book> results = query.getResultList();
        return results;
    }

    public void saveBook(Book book) {
        em.persist(book);
    }

    public void deleteBook(Book book) {
        em.remove(book);
    }

}
