package br.com.tiagobarbosa.java.jdbc.dao;

import br.com.tiagobarbosa.java.jdbc.modelo.Categoria;
import br.com.tiagobarbosa.java.jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }


    public List<Categoria> list() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = """
                SELECT ID, NOME FROM CATEGORIA;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
                    categorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }

    public List<Categoria> listWithProducts() {
        Categoria last = null;
        List<Categoria> categorias = new ArrayList<>();
        String sql = """
                SELECT
                    C.id,
                    C.nome,
                    P.id,
                    P.nome,
                    P.descricao
                FROM CATEGORIA C
                INNER JOIN PRODUTO P on C.id = P.categoria_id
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    if (last == null || !last.getNome().equals(resultSet.getString(2))) {
                        Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
                        last = categoria;
                        categorias.add(categoria);
                    }
                    Produto produto = new Produto(resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
                    last.add(produto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }
}
