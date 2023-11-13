package org.example.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostgresConnectionFactory implements IConnectionFactory {
    @Override
    public EntityManager getConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
