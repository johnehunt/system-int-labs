package com.jjh.bookshop.books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookshopJPA");
            em = emf.createEntityManager();
        }
        return em;
    }

    private EntityManagerSingleton() {}

}
