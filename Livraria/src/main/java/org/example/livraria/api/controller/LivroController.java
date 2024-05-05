package org.example.livraria.api.controller;

import org.example.livraria.api.model.Livro;
import org.example.livraria.servico.LivroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LivroController {

    private LivroServico livroServico;

    @Autowired
    public LivroController(LivroServico livroServico) {
        this.livroServico = livroServico;
    }

    @GetMapping("/livro")
    public Livro getLivro (@RequestParam Integer id){
        Optional livro = livroServico.getLivro(id);
        if (livro.isPresent()) {
            return (Livro) livro.get();
        }
        return null;
    }
}
