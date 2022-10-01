package br.com.tiagobarbosa.java.jdbc.controller;

import br.com.tiagobarbosa.java.jdbc.dao.CategoriaDAO;
import br.com.tiagobarbosa.java.jdbc.factory.ConnectionFactory;
import br.com.tiagobarbosa.java.jdbc.modelo.Categoria;

import java.sql.Connection;
import java.util.List;

public class CategoriaController {
    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        Connection connection = new ConnectionFactory().getConnection();
        this.categoriaDAO = new CategoriaDAO(connection);
    }

    public List<Categoria> listar() {
        return this.categoriaDAO.list();
    }
}
