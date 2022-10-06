package br.com.tiagobarbosa.jpa.hibernate.testes;

import br.com.tiagobarbosa.jpa.hibernate.modelo.Categoria;
import br.com.tiagobarbosa.jpa.hibernate.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("INFORMATICA");
//        Produto produto = new Produto("Controle", "Controle 8Bitdo", new BigDecimal("360"), categoria);

        EntityManager entityManager = JPAUtil.getEntityManager();
//        ProdutoDao produtoDao = new ProdutoDao(entityManager);
//        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
//        categoriaDao.cadastrar(categoria);
//        produtoDao.cadastrar(produto);
//        entityManager.getTransaction().commit();

        categoria.setName("CELULAR");

        entityManager.flush();
//        entityManager.close();

        categoria = entityManager.merge(categoria);
        categoria.setName("MÓVEIS");
        entityManager.flush();

        entityManager.remove(categoria);
        entityManager.flush();
    }
}
