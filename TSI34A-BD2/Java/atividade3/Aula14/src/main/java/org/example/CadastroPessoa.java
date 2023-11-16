package org.example;

import javax.persistence.EntityManager;

import org.example.model.Pessoa;
import org.example.model.PostgresConnectionFactory;

public class CadastroPessoa {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Nome 1");
        p.setIdade(16);

        EntityManager em = new PostgresConnectionFactory().getConnection();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

    }
}
