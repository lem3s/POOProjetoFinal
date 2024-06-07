package org.example.livraria.servico;

import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueServico {
    private Estoque estoque;

    public EstoqueServico (){
        estoque = new Estoque();

        estoque.adicionarLivro(new Livro("Capitães da Areia"));
        estoque.adicionarLivro(new Livro("O Rei da Vela"));
        estoque.adicionarLivro(new Livro("Niketche"));
    }

    public List<Livro> retornaLivrosEmEstoque() {
        return estoque.getEstoque();
    }
}
