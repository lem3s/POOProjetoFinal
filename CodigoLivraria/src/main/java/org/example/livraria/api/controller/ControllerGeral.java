package org.example.livraria.api.controller;

import org.example.livraria.api.model.Livro;
import org.example.livraria.servico.EstoqueServico;
import org.example.livraria.servico.LivroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerGeral {

    private EstoqueServico estoqueServico;
    private LivroServico livroServico;

    @Autowired
    public ControllerGeral(EstoqueServico estoqueServico, LivroServico livroServico) {
        this.estoqueServico = estoqueServico;
        this.livroServico = livroServico;
    }

    @GetMapping("/")
    public String index() {
        return "Olá!";
    }

    @GetMapping("/estoque")
    public List<Livro> getEstoque (){
        return estoqueServico.retornaLivrosEmEstoque();
    }

    @PostMapping("/adicionaLivro")
    public Livro adicionaLivro(@RequestBody Livro livro) {
        return estoqueServico.adicionaLivro(livro);
    }
}
