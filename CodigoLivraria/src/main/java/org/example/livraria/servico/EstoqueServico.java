package org.example.livraria.servico;

import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueServico {
    private Estoque estoque;
    private static final String ARQUIVO_ESTOQUE = "estoque.ser";

    public EstoqueServico (){
        if (PersistenciaUtil.arquivoExiste(ARQUIVO_ESTOQUE)){
           estoque.adicionarListaDeLivros(PersistenciaUtil.desserealizarLista(ARQUIVO_ESTOQUE));
        }
        else {
            estoque = new Estoque();
        }
    }

    public List<Livro> retornaLivrosEmEstoque() {
        return estoque.getEstoque();
    }

    public Livro adicionaLivro(Livro livro) {
        estoque.adicionarLivro(livro);
        PersistenciaUtil.serializaLista(estoque.getEstoque(), ARQUIVO_ESTOQUE);
        return livro;
    }
}
