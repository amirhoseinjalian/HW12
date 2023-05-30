package com.jalian.hw12.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class HibernateUtil {
    private static final EntityManagerFactory entityMangerFactory;
    private static final EntityManager entityManager;

    static {
        entityMangerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        entityManager = entityMangerFactory.createEntityManager();
    }

    public static EntityManager getEntityManger() {
        return entityManager;
    }
    public static void close() {
        if(entityManager != null) {
            entityManager.close();
        }
        if(entityMangerFactory.isOpen()) {
            entityMangerFactory.close();
        }
    }
}