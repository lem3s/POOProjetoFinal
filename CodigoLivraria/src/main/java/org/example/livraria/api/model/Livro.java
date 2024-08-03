package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.List;

public class Livro implements Serializable {
    private static int contador = 1;

    private int id;
    private String titulo;
    private Autor autor;
    private double preco;
    private int quantidade;

    public Livro() {
        this.id = contador++;
    }

    public Livro(String titulo) {
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) { this.autor = autor; }

    public double getPreco() { return preco; }

    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
}
