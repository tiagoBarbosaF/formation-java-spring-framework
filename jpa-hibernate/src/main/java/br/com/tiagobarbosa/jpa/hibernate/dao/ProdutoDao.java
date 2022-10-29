package br.com.tiagobarbosa.jpa.hibernate.dao;

import br.com.tiagobarbosa.jpa.hibernate.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);

        Predicate filtros = builder.and();
        if (nome != null && !nome.trim().isEmpty()) {
            filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
        }
        if (preco != null) {
            filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
        }
        if (dataCadastro != null) {
            filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
        }
        query.where(filtros);
        return entityManager.createQuery(query).getResultList();
    }
}
