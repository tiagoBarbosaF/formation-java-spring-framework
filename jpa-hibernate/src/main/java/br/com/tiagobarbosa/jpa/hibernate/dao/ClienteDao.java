package br.com.tiagobarbosa.jpa.hibernate.dao;

import br.com.tiagobarbosa.jpa.hibernate.modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteDao {
    private final EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return entityManager.find(Cliente.class, id);
    }
}
