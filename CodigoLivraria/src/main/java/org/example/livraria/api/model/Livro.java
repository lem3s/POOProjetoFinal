package org.example.livraria.api.model;

enum Generos {
    FICCAO,
    TERROR,
    BIOGRAFIA,
    INFANTIL,
    ACADEMICO,
    ROMANCE
}

public class Livro {
    private static int contador = 1;

    private int id;
    private String titulo;
    private String autor;
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
