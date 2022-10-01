package br.com.tiagobarbosa.java.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private final Integer id;
    private final String nome;
    private final List<Produto> produtos = new ArrayList<>();

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }
}
