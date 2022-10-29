package br.com.tiagobarbosa.jpa.hibernate.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @EmbeddedId
    private CategoriaId id;

    public Categoria() {

    }

    public Categoria(String nome) {
        this.id = new CategoriaId(nome, "nome");
    }

    public String getName() {
        return this.id.getNome();
    }
}
