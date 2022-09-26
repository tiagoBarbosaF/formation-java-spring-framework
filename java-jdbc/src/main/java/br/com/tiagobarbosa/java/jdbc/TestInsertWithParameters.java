package br.com.tiagobarbosa.java.jdbc;

import java.sql.*;

public class TestInsertWithParameters {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try (Connection connection = connectionFactory.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement("""
                    INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)
                    """, Statement.RETURN_GENERATED_KEYS)) {
                addVariable("SmartTV", "Samsung NQLED 49\"", preparedStatement);
                addVariable("Video-Game", "Console Playstation 5", preparedStatement);

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Rollback executed.");
                connection.rollback();
            }
        }
    }

    private static void addVariable(String nome, String description, PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, description);

        preparedStatement.execute();

        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            while (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                System.out.printf("Item inserido - ID: %d%n", id);
            }
        }
    }
}
