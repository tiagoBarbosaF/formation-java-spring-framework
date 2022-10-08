package br.com.tiagobarbosa.jpa.hibernate.testes;

import br.com.tiagobarbosa.jpa.hibernate.dao.CategoriaDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ProdutoDao;
import br.com.tiagobarbosa.jpa.hibernate.modelo.Categoria;
import br.com.tiagobarbosa.jpa.hibernate.modelo.Produto;
import br.com.tiagobarbosa.jpa.hibernate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastraCategoriaEProduto();
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        Produto produto = produtoDao.buscarPorId(1L);
        System.out.printf("%n%nNome: %s, Descrição: %s, Valor: %s%n", produto.getNome(), produto.getDescricao(),
                produto.getPreco());

        System.out.println("Buscar todos");
        List<Produto> produtos = produtoDao.buscarTodos();
        produtos.forEach(System.out::println);

        System.out.println("Buscar por nome do produto");
        List<Produto> controle = produtoDao.buscarPorNome("Controle");
        controle.forEach(System.out::println);

        System.out.println("Buscar por nome da categoria");
        List<Produto> informatica = produtoDao.buscarPorCategoria("INFORMATICA");
        informatica.forEach(System.out::println);

        System.out.println("Retorna preço produto");
        BigDecimal controle1 = produtoDao.retornarPrecoProduto("Controle");
        System.out.println(controle1);
    }

    private static void cadastraCategoriaEProduto() {
        Categoria categoria = new Categoria("INFORMATICA");
        Produto produto = new Produto("Controle", "Controle 8Bitdo", new BigDecimal("360"), categoria);
        Produto produto2 = new Produto("Teclado Mecânico", "Nuphy 75%", new BigDecimal("800"), categoria);

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(produto);
        produtoDao.cadastrar(produto2);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
