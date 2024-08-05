package org.example.livraria.servico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.livraria.api.model.Vendedor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * O Serviço que irá gerenciar os vendedores
 */
@Service
public class VendedorServico {
    private static final String ARQUIVO_VENDEDORES = "vendedores.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Vendedor> vendedores;

    /**
     * Construtor instancia a lista de vendedores e verifica se o arquivo de persistência existe e se existir carrega os
     * dados que estão nele
     */
    public VendedorServico() {
        vendedores = new ArrayList<Vendedor>();

        if (PersistenciaUtil.arquivoExiste(ARQUIVO_VENDEDORES)) {
            carregaVendedores();
        }
    }

    /**
     * Retorna os vendedores cadastrados
     * @return A lista de vendedores
     */
    public List<Vendedor> retornaVendedores() { return vendedores; }

    /**
     * Adiciona um novo vendedor a lista de vendedores do sistema e salva a lista de vendedores atualizada no arquivo de
     * persistência
     * @param vendedor O objeto vendedore a ser adicionado
     * @return O objeto que foi adicionado
     */
    public Vendedor adicionaVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
        salvaVendedores();

        return vendedor;
    }

    /**
     * Varre a lista de vendedores procurando se há um vendedor com aquele CPF e se houver remove-o da lista
     * @param cpf O CPF do vendedor que se deseja remover
     * @return True se encontrou e removeou o vendedores e false se não econtrou o vendedor na lista
     */
    public boolean removeVendedor(String cpf) {
        for (Vendedor _vendedor : vendedores) {
            if (_vendedor.getcpf().equals(cpf)) {
                vendedores.remove(_vendedor);
                return true;
            }
        }
        return false;
    }

    /**
     * Serializa e salva a lista de vendedores e suas informações em um arquivo json
     */
    public void salvaVendedores() {
        try {
            objectMapper.writeValue(new java.io.File(ARQUIVO_VENDEDORES), vendedores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Desserializa e carrega a lista de vendedores do arquivo json persistido
     */
    public void carregaVendedores() {
        try {
            vendedores = objectMapper.readValue(new java.io.File(ARQUIVO_VENDEDORES), new TypeReference<List<Vendedor>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
