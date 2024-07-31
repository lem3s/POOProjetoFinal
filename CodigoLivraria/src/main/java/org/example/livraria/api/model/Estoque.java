package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Serializable {
    private List<Livro> livros = new ArrayList<Livro>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public boolean removerLivro(Livro livro) {
        for (Livro _livro : livros) {
            if (_livro.getId() == livro.getId()) {
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
