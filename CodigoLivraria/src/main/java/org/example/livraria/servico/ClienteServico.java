package org.example.livraria.servico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.livraria.api.model.Cliente;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * O Serviço que irá gerenciar os clientes
 */
@Service
public class ClienteServico {
    private static final String ARQUIVO_CLIENTES = "clientes.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Cliente> clientes;

    /**
     * Construtor instancia a lista de clientes e verifica se o arquivo de persistência existe e se existir carrega os
     * dados que estão nele
     */
    public ClienteServico() {
        clientes = new ArrayList<>();

        if (PersistenciaUtil.arquivoExiste(ARQUIVO_CLIENTES)) {
            carregaClientes();
        }
    }

    /**
     * Retorna os clientes cadastrados
     * @return A lista de clientes
     */
    public List<Cliente> retornaClientes() { return clientes; }

    /**
     * Adiciona um novo cliente a lista de clientes do sistema e salva a lista de clientes atualizada no arquivo de
     * persistência
     * @param cliente O objeto cliente a ser adicionado
     * @return O objeto que foi adicionado
     */
    public Cliente adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
        salvaClientes();
        return cliente;
    }

    /**
     * Varre a lista de clientes procurando se há um cliente com aquele CPF e se houver remove-o da lista
     * @param cpf O CPF do cliente que se deseja remover
     * @return True se encontrou e removeou o cliente e false se não econtrou o cliente na lista
     */
    public boolean removeCliente(String cpf) {

        for (Cliente _cliente : clientes) {
            if (_cliente.getcpf().equals(cpf)) {
                clientes.remove(_cliente);
                return true;
            }
        }
        return false;
    }

    /**
     * Serializa e salva a lista de clientes e suas informações em um arquivo json
     */
    private void salvaClientes() {
        try {
            objectMapper.writeValue(new File(ARQUIVO_CLIENTES), clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Desserializa e carrega a lista de clientes do arquivo json persistido
     */
    private void carregaClientes() {
        try {
            clientes = objectMapper.readValue(new File(ARQUIVO_CLIENTES), new TypeReference<List<Cliente>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
