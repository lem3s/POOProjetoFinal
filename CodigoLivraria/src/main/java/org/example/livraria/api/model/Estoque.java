package org.example.livraria.api.model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    List<Livro> livros = new ArrayList<>();

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
}
