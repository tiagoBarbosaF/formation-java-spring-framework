package br.com.tiagobarbosa.java.jdbc;

import java.sql.*;

public class TestInsertWithParameters {
    public static void main(String[] args) throws SQLException {
        String nome = "Mala'";
        String description = "Aventuras nas cordilheiras.); delete from Produto;";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("""
                INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)
                """, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, description);
        preparedStatement.execute();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        while (generatedKeys.next()) {
            Integer id = generatedKeys.getInt(1);

            System.out.printf("Item inserido - ID: %d%n", id);
        }
    }
}
