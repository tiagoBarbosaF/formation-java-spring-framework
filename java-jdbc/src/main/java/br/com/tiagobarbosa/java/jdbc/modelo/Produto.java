package br.com.tiagobarbosa.java.jdbc.modelo;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "{\"Produto\":{" +
                "\"id\":" + id +
                ", \"nome\":\"" + nome + '\"' +
                ", \"descricao\":\"" + descricao + '\"' +
                '}'+"}";
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
