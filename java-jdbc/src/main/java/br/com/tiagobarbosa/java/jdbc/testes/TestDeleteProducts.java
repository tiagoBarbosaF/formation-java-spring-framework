package br.com.tiagobarbosa.java.jdbc.testes;

import br.com.tiagobarbosa.java.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDeleteProducts {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("""
                DELETE FROM PRODUTO WHERE ID > 14;
                """);
        preparedStatement.execute();

        Integer updateCount = preparedStatement.getUpdateCount();
        System.out.printf("Quantidade de linhas afetadas: %d%n", updateCount);
    }
}
