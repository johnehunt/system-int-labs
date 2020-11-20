package com.jjh.bookshop.books;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDAO {

    private EntityManager em;

    public void setup() {
        em = EntityManagerSingleton.getEntityManager();
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
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public void deleteBook(Book book) {
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

}
