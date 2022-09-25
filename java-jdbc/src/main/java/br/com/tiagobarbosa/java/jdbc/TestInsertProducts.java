package br.com.tiagobarbosa.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertProducts {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement statement = connection.createStatement();
        statement.execute("""
                INSERT INTO PRODUTO (nome, descricao) VALUES('MOUSE', 'MOUSE WIRELESS')
                """, Statement.RETURN_GENERATED_KEYS);

        ResultSet generatedKeys = statement.getGeneratedKeys();
        while (generatedKeys.next()){
            Integer id = generatedKeys.getInt(1);

            System.out.printf("Item inserido - ID: %d%n", id);
        }
    }
}
