package br.com.tiagobarbosa.jpa.hibernate.dao;

import br.com.tiagobarbosa.jpa.hibernate.modelo.Pedido;

import javax.persistence.EntityManager;

public class PedidoDao {
    private final EntityManager entityManager;

    public PedidoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido) {
        this.entityManager.persist(pedido);
    }
}
