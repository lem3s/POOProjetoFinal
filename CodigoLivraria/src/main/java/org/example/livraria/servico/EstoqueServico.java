package org.example.livraria.servico;

import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;

import java.util.ArrayList;

public class EstoqueServico {
    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    private Estoque estoque;

    public EstoqueServico (){
        Estoque estoque = new Estoque();

        estoque.adicionarLivro(new Livro("Capitães da Areia"));
        estoque.adicionarLivro(new Livro("O Rei da Vela"));
        estoque.adicionarLivro(new Livro("Niketche"));
    }
}
