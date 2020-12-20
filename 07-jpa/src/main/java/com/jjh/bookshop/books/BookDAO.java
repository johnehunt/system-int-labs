package com.jjh.bookshop.books;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDAO {

    /**
     * Holds the JPA Entity Manager.
     * Handles persistence of entities
     */
    private EntityManager em;

    /**
     * Sets up the Entity Manager.
     */
    public void setup() {
        System.out.println("BookDAO.setup()");
        em = EntityManagerSingleton.getEntityManager();
    }

    public Book getBookByISBN(int isbn) {
        System.out.printf("BookDAO.getBookByISBN(%s)\n", isbn);
        Book book = em.find(Book.class, isbn);
        return book;
    }

    public List<Book> getBooks() {
        System.out.println("BookDAO.getBooks()");
        String jql = "SELECT b FROM Book b";
        System.out.println(jql);
        TypedQuery<Book> query = em.createQuery(jql, Book.class);
        List<Book> results = query.getResultList();
        return results;
    }

    public void saveBook(Book book) {
        System.out.printf("BookDAO.saveBook(%s)\n", book);
        // Note the use of Transactions
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public void deleteBook(Book book) {
        System.out.printf("BookDAO.deleteBook(%s)\n", book);
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

}
