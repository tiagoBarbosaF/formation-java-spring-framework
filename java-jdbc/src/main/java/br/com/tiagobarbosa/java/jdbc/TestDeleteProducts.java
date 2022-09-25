package br.com.tiagobarbosa.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDeleteProducts {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement statement = connection.createStatement();
        statement.execute("""
                DELETE FROM PRODUTO WHERE ID > 2;
                """);

        Integer updateCount = statement.getUpdateCount();
        System.out.printf("Quantidade de linhas afetadas: %d%n", updateCount);
    }
}
