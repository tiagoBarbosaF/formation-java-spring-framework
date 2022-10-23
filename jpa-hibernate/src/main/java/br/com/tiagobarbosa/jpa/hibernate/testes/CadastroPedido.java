package br.com.tiagobarbosa.jpa.hibernate.testes;

import br.com.tiagobarbosa.jpa.hibernate.dao.CategoriaDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ClienteDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.PedidoDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ProdutoDao;
import br.com.tiagobarbosa.jpa.hibernate.modelo.*;
import br.com.tiagobarbosa.jpa.hibernate.util.JPAUtil;
import br.com.tiagobarbosa.jpa.hibernate.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroPedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        Produto produto1 = produtoDao.buscarPorId(1L);
        Produto produto2 = produtoDao.buscarPorId(2L);
        Produto produto3 = produtoDao.buscarPorId(3L);
        List<Produto> produtos = produtoDao.buscarTodos();
        ClienteDao clienteDao = new ClienteDao(entityManager);
        Cliente cliente = clienteDao.buscarPorId(1L);

        entityManager.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
//        produtos.forEach(produto -> pedido.adicionarItem(new ItemPedido(5, pedido, produto)));
        pedido.adicionarItem(new ItemPedido(5, pedido, produto1));
        pedido.adicionarItem(new ItemPedido(15, pedido, produto2));
        pedido.adicionarItem(new ItemPedido(20, pedido, produto3));

        PedidoDao pedidoDao = new PedidoDao(entityManager);
        pedidoDao.cadastrar(pedido);
        entityManager.getTransaction().commit();

        BigDecimal totalVendido = pedidoDao.valorTotalVendido();
        System.out.printf("Valor total: %s", totalVendido);

        List<RelatorioDeVendasVo> relatorioDeVendas = pedidoDao.relatorioDeVendas();
        relatorioDeVendas.forEach(System.out::println);
    }

    private static void popularBancoDeDados() {
        Categoria categoria1 = new Categoria("INFORMATICA");
        Categoria categoria2 = new Categoria("CELULARES");
        Categoria categoria3 = new Categoria("VIDEOGAMES");
//        Produto produto = new Produto("Controle", "Controle 8Bitdo", new BigDecimal("360"), categoria1);
//        Produto produto2 = new Produto("Controle", "Controle 8Bitdo", new BigDecimal("360"), categoria1);
//        Produto produto3 = new Produto("Controle", "Controle 8Bitdo", new BigDecimal("360"), categoria1);
//        Produto produto4 = new Produto("Teclado Mecânico", "Nuphy 75%", new BigDecimal("800"), categoria1);
        Produto produto1 =
                new Produto("Redmi 12s Ultra", "Celular Xiaomi", new BigDecimal("8300.50"), categoria2);
        Produto produto2 =
                new Produto("PlayStation 5", "Console", new BigDecimal("4500.50"), categoria3);
        Produto produto3 =
                new Produto("Macbook Air M1", "Notebook Apple", new BigDecimal("6800"), categoria1);
        Cliente cliente = new Cliente("Tiago", "123456");

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();

//        entityManager.persist(categoria1);
        categoriaDao.cadastrar(categoria1);
        categoriaDao.cadastrar(categoria2);
        categoriaDao.cadastrar(categoria3);
        produtoDao.cadastrar(produto1);
        produtoDao.cadastrar(produto2);
        produtoDao.cadastrar(produto3);
        clienteDao.cadastrar(cliente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
