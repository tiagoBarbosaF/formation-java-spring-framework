package br.com.tiagobarbosa.jpa.hibernate.dao;

import br.com.tiagobarbosa.jpa.hibernate.modelo.Pedido;
import br.com.tiagobarbosa.jpa.hibernate.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private final EntityManager entityManager;

    public PedidoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido) {
        this.entityManager.persist(pedido);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return entityManager.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<RelatorioDeVendasVo> relatorioDeVendas() {
        String jpql = """
                SELECT new br.com.tiagobarbosa.jpa.hibernate.vo.RelatorioDeVendasVo(
                produto.nome,
                SUM(item.quantidade),
                MAX(pedido.data))
                FROM Pedido pedido
                JOIN pedido.itens item
                JOIN item.produto produto
                GROUP BY produto.nome
                ORDER BY item.quantidade DESC
                """;
        return entityManager.createQuery(jpql, RelatorioDeVendasVo.class)
                .getResultList();
    }

    public Pedido buscarPedidoComCliente(Long id) {
        return entityManager.createQuery("""
                        SELECT p
                        FROM Pedido p
                        JOIN FETCH p.cliente
                        WHERE
                        p.id = :id
                        """, Pedido.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
