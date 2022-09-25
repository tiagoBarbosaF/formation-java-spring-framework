package br.com.tiagobarbosa.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestListProducts {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement statement = connection.createStatement();
        statement.execute("""
                SELECT
                    ID,
                    NOME,
                    DESCRICAO
                FROM PRODUTO
                """);
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID");
            String nome = resultSet.getString("NOME");
            String descricao = resultSet.getString("DESCRICAO");
            System.out.printf("ID: %d, NOME: %s, DESCRICAO: %s%n", id, nome, descricao);
        }

        connection.close();
    }
}