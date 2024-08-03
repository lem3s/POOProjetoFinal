package org.example.livraria.servico;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;

@Service
public class EstoqueServico {
    private static final String ARQUIVO_ESTOQUE = "estoque.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private Estoque estoque;

    public EstoqueServico (){
        estoque = new Estoque();

        if (PersistenciaUtil.arquivoExiste(ARQUIVO_ESTOQUE)){
           carregaEstoque();
        }
    }

    public List<Livro> retornaLivrosEmEstoque() {
        return estoque.getEstoque();
    }

    public Livro adicionaLivro(Livro livro) {
        estoque.adicionarLivro(livro);
        salvaEstoque();
        return livro;
    }

    private void salvaEstoque() {
        try {
            objectMapper.writeValue(new File(ARQUIVO_ESTOQUE), estoque);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregaEstoque() {
        try {
            estoque = objectMapper.readValue(new File(ARQUIVO_ESTOQUE), new TypeReference<Estoque>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
