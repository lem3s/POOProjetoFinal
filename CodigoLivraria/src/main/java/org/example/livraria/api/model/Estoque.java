package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Serializable {
    private List<Livro> livros = new ArrayList<Livro>();

    public Estoque() {
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarListaDeLivros(List<Livro> livros) {
        this.livros.addAll(livros);
    }

    public boolean removerLivro(int id) {
        for (Livro _livro : livros) {
            if (_livro.getId() == id) {
                livros.remove(_livro);
                return true;
            }
        }
        return false;
    }

    public List<Livro> getEstoque(){
       return livros;
    }
}
