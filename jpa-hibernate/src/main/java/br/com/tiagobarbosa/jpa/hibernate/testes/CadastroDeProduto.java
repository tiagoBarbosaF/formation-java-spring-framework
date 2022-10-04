package br.com.tiagobarbosa.jpa.hibernate.testes;

import br.com.tiagobarbosa.jpa.hibernate.dao.CategoriaDao;
import br.com.tiagobarbosa.jpa.hibernate.dao.ProdutoDao;
import br.com.tiagobarbosa.jpa.hibernate.modelo.Categoria;
import br.com.tiagobarbosa.jpa.hibernate.modelo.Produto;
import br.com.tiagobarbosa.jpa.hibernate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("INFORMATICA");
        Produto produto = new Produto("Controle", "Controle 8Bitdo", new BigDecimal("360"), categoria);

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
