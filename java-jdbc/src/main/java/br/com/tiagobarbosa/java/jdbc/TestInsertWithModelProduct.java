package br.com.tiagobarbosa.java.jdbc;

import br.com.tiagobarbosa.java.jdbc.dao.ProdutoDAO;
import br.com.tiagobarbosa.java.jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestInsertWithModelProduct {
    public static void main(String[] args) throws SQLException {
        Produto produto = new Produto("Móveis", "Guarda-roupas com espelho");

        try (Connection connection = new ConnectionFactory().getConnection()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.save(produto);
            List<Produto> listProdutos = produtoDAO.list();
            listProdutos.forEach(System.out::println);
        }
    }
}
