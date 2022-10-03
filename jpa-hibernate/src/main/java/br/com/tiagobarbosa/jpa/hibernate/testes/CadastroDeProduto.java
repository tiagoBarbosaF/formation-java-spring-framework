package br.com.tiagobarbosa.jpa.hibernate.testes;

import br.com.tiagobarbosa.jpa.hibernate.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Controle");
        produto.setDescricao("Controle 8Bitdo");
        produto.setPreco(new BigDecimal("360"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
