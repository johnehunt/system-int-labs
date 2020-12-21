package com.jjh.bookshop.books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDAO {

    /**
     * Holds the JPA Entity Manager.
     * Handles persistence of entities
     */
    private EntityManager em;
    private static final String persistenceUnitName = "BookshopJPA";

    /**
     * Sets up the Entity Manager.
     */
    public void setup() {
        System.out.println("BookDAO.setup()");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
    }

    public Book getBookByISBN(int isbn) {
        System.out.printf("BookDAO.getBookByISBN(%s)\n", isbn);
        Book book = em.find(Book.class, isbn);
        return book;
    }

    public List<Book> getAllBooks() {
        System.out.println("BookDAO.getAllBooks()");
        
        String jql = "SELECT b FROM Book b";
        System.out.println(jql);
        // Query query2 = em.createNativeQuery("SELECT * FROM books", Book.class);
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

    public void updateBook(Book book) {
        saveBook(book);
    }

    public void deleteBook(Book book) {
        System.out.printf("BookDAO.deleteBook(%s)\n", book);
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

}
