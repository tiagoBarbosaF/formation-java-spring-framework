package br.com.tiagobarbosa.java.jdbc.dao;

import br.com.tiagobarbosa.java.jdbc.modelo.Categoria;
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
            throw new RuntimeException(e);
        }
    }

    public void saveWithCategory(Produto produto) {
        String sql = """
                INSERT INTO PRODUTO (NOME, DESCRICAO, CATEGORIA_ID) VALUES(?,?,?);
                                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setInt(3, produto.getCategoriaId());

            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    produto.setId(generatedKeys.getInt(1));
                }
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

            transformResultSetInProduct(produtos, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public List<Produto> search(Categoria categoria) {
        List<Produto> produtos = new ArrayList<>();
        String sql = """
                SELECT
                    P.ID,
                    P.NOME,
                    DESCRICAO
                FROM PRODUTO P
                WHERE
                    P.categoria_id = ?
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, categoria.getId());
            preparedStatement.execute();

            transformResultSetInProduct(produtos, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void delete(Integer id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("""
                DELETE FROM PRODUTO WHERE ID = ?
                """)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(String nome, String descricao, Integer id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("""
                UPDATE PRODUTO P
                SET P.nome= ?,
                    P.descricao = ?
                WHERE id = ?
                """)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, descricao);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void transformResultSetInProduct(List<Produto> produtos, PreparedStatement preparedStatement)
            throws SQLException {
        try (ResultSet resultSet = preparedStatement.getResultSet()) {
            while (resultSet.next()) {
                Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                produtos.add(produto);
            }
        }
    }
}
