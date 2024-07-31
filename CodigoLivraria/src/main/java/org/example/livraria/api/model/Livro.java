package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.List;

public class Livro implements Serializable {
    private static int contador = 1;

    private int id;
    private String titulo;
    private List<Autor> autores;
    private double preco;
    private int quantidade;

    public Livro(String titulo) {
        this.id = contador++;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
