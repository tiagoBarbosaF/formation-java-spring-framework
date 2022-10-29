package br.com.tiagobarbosa.jpa.hibernate.testes;

import br.com.tiagobarbosa.jpa.hibernate.dao.CategoriaDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ClienteDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.PedidoDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ProdutoDao;
import br.com.tiagobarbosa.jpa.hibernate.modelo.*;
import br.com.tiagobarbosa.jpa.hibernate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestCriteria {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        produtoDao.buscarPorParametros(null, null, LocalDate.now());
    }

    private static void popularBancoDeDados() {
        Categoria categoria1 = new Categoria("INFORMATICA");
        Categoria categoria2 = new Categoria("CELULARES");
        Categoria categoria3 = new Categoria("VIDEOGAMES");
        Produto produto1 =
                new Produto("Redmi 12s Ultra", "Celular Xiaomi", new BigDecimal("8300.50"), categoria2);
        Produto produto2 =
                new Produto("PlayStation 5", "Console", new BigDecimal("4500.50"), categoria3);
        Produto produto3 =
                new Produto("Macbook Air M1", "Notebook Apple", new BigDecimal("6800"), categoria1);
        Cliente cliente = new Cliente("Tiago", "123456");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(5, pedido, produto1));
        pedido.adicionarItem(new ItemPedido(15, pedido, produto2));

        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarItem(new ItemPedido(15, pedido, produto2));

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        PedidoDao pedidoDao = new PedidoDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(categoria1);
        categoriaDao.cadastrar(categoria2);
        categoriaDao.cadastrar(categoria3);
        produtoDao.cadastrar(produto1);
        produtoDao.cadastrar(produto2);
        produtoDao.cadastrar(produto3);
        clienteDao.cadastrar(cliente);
        pedidoDao.cadastrar(pedido);
        pedidoDao.cadastrar(pedido2);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
