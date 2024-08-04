package org.example.livraria.servico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.livraria.api.model.Cliente;
import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServico {
    private static final String ARQUIVO_CLIENTES = "clientes.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Cliente> clientes;

    public ClienteServico() {
        clientes = new ArrayList<>();

        if (PersistenciaUtil.arquivoExiste(ARQUIVO_CLIENTES)) {
            carregaClientes();
        }
    }

    public List<Cliente> retornaClientes() { return clientes; }

    public Cliente adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
        salvaClientes();
        return cliente;
    }

    public boolean removeCliente(String cpf) {

        for (Cliente _cliente : clientes) {
            if (_cliente.getcpf().equals(cpf)) {
                clientes.remove(_cliente);
                return true;
            }
        }
        return false;
    }

    private void salvaClientes() {
        try {
            objectMapper.writeValue(new File(ARQUIVO_CLIENTES), clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregaClientes() {
        try {
            clientes = objectMapper.readValue(new File(ARQUIVO_CLIENTES), new TypeReference<List<Cliente>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
