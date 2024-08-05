package org.example.livraria.servico;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;

/**
 * O Serviço que irá gerenciar o estoque
 */
@Service
public class EstoqueServico {
    private static final String ARQUIVO_ESTOQUE = "estoque.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private Estoque estoque;

    /**
     * Construtor instancia o estoque e verifica se o arquivo de persistência existe e se existir carrega os
     * dados que estão nele
     */
    public EstoqueServico (){
        estoque = new Estoque();

        if (PersistenciaUtil.arquivoExiste(ARQUIVO_ESTOQUE)){
           carregaEstoque();
        }
    }

    /**
     * Retorna os livros em estoque
     * @return A lista de livros
     */
    public List<Livro> retornaLivrosEmEstoque() {
        return estoque.getEstoque();
    }

    /**
     * Adiciona um novo livro ao estoque e salva o estoque atualizado no arquivo de
     * persistência
     * @param livro O objeto livro a ser adicionado
     * @return O objeto que foi adicionado
     */
    public Livro adicionaLivro(Livro livro) {
        estoque.adicionarLivro(livro);
        salvaEstoque();
        return livro;
    }

    /**
     * Varre a lista o estoque procurando se há um livro com aquele id e se houver remove-o da lista
     * @param id O id do livro que se deseja remover
     * @return True se encontrou e removeou o livro e false se não econtrou o livro na lista
     */
    public boolean removerLivro(int id) {
       return estoque.removerLivro(id);
    }

    /**
     * Serializa e salva o estoque e suas informações em um arquivo json
     */
    private void salvaEstoque() {
        try {
            objectMapper.writeValue(new File(ARQUIVO_ESTOQUE), estoque);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Desserializa e carrega o estoque do arquivo json persistido
     */
    private void carregaEstoque() {
        try {
            estoque = objectMapper.readValue(new File(ARQUIVO_ESTOQUE), new TypeReference<Estoque>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
