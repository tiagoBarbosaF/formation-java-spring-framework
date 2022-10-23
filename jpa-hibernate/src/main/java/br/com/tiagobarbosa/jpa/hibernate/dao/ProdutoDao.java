package br.com.tiagobarbosa.jpa.hibernate.dao;

import br.com.tiagobarbosa.jpa.hibernate.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        this.entityManager.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String consulta = "SELECT p FROM Produto p";
        return entityManager.createQuery(consulta, Produto.class).getResultList();
    }

    //    public List<Produto> buscarPorNome(String nome) {
//        String consulta = "SELECT p FROM Produto p WHERE p.nome = :nome";
//        return entityManager.createQuery(consulta, Produto.class)
//                .setParameter("nome", nome)
//                .getResultList();
//    }

    // Utilizando NamedQuery
    public List<Produto> buscarPorNome(String nome) {
        return entityManager.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorCategoria(String nome) {
        String consulta = "SELECT p FROM Produto p WHERE p.categoria.name = :nome";
        return entityManager.createQuery(consulta, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal retornarPrecoProduto(String nome) {
        String consulta = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return entityManager.createQuery(consulta, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
