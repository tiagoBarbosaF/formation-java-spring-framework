package br.com.tiagobarbosa.java.jdbc;

import java.sql.*;

public class TestListProducts {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT
                    ID,
                    NOME,
                    DESCRICAO
                FROM PRODUTO
                """);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID");
            String nome = resultSet.getString("NOME");
            String descricao = resultSet.getString("DESCRICAO");
            System.out.printf("ID: %d, NOME: %s, DESCRICAO: %s%n", id, nome, descricao);
        }

        connection.close();
    }
}
