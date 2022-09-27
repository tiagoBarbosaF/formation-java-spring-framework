package br.com.tiagobarbosa.java.jdbc.dao;

import br.com.tiagobarbosa.java.jdbc.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Produto produto) {
        String sql = """
                INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (? ,?);
                    """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.execute();
            connection.commit();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    produto.setId(generatedKeys.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Rollback executed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> list() {
        List<Produto> produtos = new ArrayList<>();
        String sql = """
                SELECT
                    ID,
                    NOME,
                    DESCRICAO
                FROM PRODUTO
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
