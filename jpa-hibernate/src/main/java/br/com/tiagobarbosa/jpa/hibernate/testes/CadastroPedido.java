package br.com.tiagobarbosa.jpa.hibernate.testes;

import br.com.tiagobarbosa.jpa.hibernate.dao.CategoriaDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ClienteDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.PedidoDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ProdutoDao;
import br.com.tiagobarbosa.jpa.hibernate.modelo.*;
import br.com.tiagobarbosa.jpa.hibernate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroPedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        Produto produto = produtoDao.buscarPorId(1L);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        Cliente cliente = clienteDao.buscarPorId(1L);

        entityManager.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(5, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(entityManager);
        pedidoDao.cadastrar(pedido);
        entityManager.getTransaction().commit();
    }

    private static void popularBancoDeDados() {
        Categoria categoria = new Categoria("INFORMATICA");
        Produto produto = new Produto("Controle", "Controle 8Bitdo", new BigDecimal("360"), categoria);
        Produto produto2 = new Produto("Teclado Mecânico", "Nuphy 75%", new BigDecimal("800"), categoria);
        Cliente cliente = new Cliente("Tiago", "123456");

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();

        entityManager.persist(categoria);
        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(produto);
        produtoDao.cadastrar(produto2);
        clienteDao.cadastrar(cliente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
