package br.com.tiagobarbosa.java.jdbc.controller;

import br.com.tiagobarbosa.java.jdbc.dao.ProdutoDAO;
import br.com.tiagobarbosa.java.jdbc.factory.ConnectionFactory;
import br.com.tiagobarbosa.java.jdbc.modelo.Produto;

import java.sql.Connection;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        Connection connection = new ConnectionFactory().getConnection();
        this.produtoDAO = new ProdutoDAO(connection);
    }

    public void delete(Integer id) {
        this.produtoDAO.delete(id);
    }

    public void save(Produto produto) {
        this.produtoDAO.saveWithCategory(produto);
    }

    public List<Produto> list() {
        return this.produtoDAO.list();
    }

    public void edit(String nome, String descricao, Integer id) {
        this.produtoDAO.edit(nome, descricao, id);
    }
}
