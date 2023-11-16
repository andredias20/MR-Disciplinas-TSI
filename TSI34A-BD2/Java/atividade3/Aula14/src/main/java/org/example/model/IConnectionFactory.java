package org.example.model;

import javax.persistence.EntityManager;

public interface IConnectionFactory {
    EntityManager getConnection();
}
