package br.com.tiagobarbosa.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        System.out.println("Close connection");
        connection.close();
    }
}