package br.com.tiagobarbosa.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDeleteProducts {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("""
                DELETE FROM PRODUTO WHERE ID = 18;
                """);
        preparedStatement.execute();

        Integer updateCount = preparedStatement.getUpdateCount();
        System.out.printf("Quantidade de linhas afetadas: %d%n", updateCount);
    }
}
