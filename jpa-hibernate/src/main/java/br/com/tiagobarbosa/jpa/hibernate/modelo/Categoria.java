package br.com.tiagobarbosa.jpa.hibernate.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Categoria(String name) {
        this.name = name;
    }

    public Categoria() {

    }

    public String getName() {
        return name;
    }
}
