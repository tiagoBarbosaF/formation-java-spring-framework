package br.com.tiagobarbosa.java.jdbc;

import br.com.tiagobarbosa.java.jdbc.dao.CategoriaDAO;
import br.com.tiagobarbosa.java.jdbc.modelo.Categoria;
import br.com.tiagobarbosa.java.jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestListCategories {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> categoriaList = categoriaDAO.listWithProducts();
            categoriaList.forEach(categoria -> {
                System.out.println("\n" + categoria.getNome());
                for (Produto produto :
                        categoria.getProdutos()) {
                    System.out.printf(" - Nome: %s, Descrição: %s%n", produto.getNome(), produto.getDescricao());
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
