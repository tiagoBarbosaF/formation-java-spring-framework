package br.com.tiagobarbosa.java.jdbc.testes;

import br.com.tiagobarbosa.java.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPoolConnection {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 30; i++) {
            try (Connection connection = connectionFactory.getConnection()) {
                System.out.printf("Conexão aberta de número: %d%n", i);
            }
        }
    }
}
