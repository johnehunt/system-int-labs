package com.jjh.bookshop.dao;

import com.jjh.bookshop.domain.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component("JPABookDAO")
public class JPABookDAOImpl implements BookDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> getBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        entityManager.remove(book);
    }
}
