package org.example.livraria.servico;

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
    private static final String ARQUIVO_CLIENTES = "clientes.ser";
    private ObjectMapper objectMapper = new ObjectMapper();
    private Cliente clientes;

    public ClienteServico() {
        if (PersistenciaUtil.arquivoExiste(ARQUIVO_CLIENTES)) {
            carregaClientes();
        }
    }

    public List<Cliente> retornaClientes() { return clientes.getClientes(); }

    public Cliente adicionaCliente(Cliente cliente) {
        cliente.adicionarCliente(clientes);
        salvaClientes();
        return cliente;
    }

    public boolean removeCliente(String cpf) {
        return clientes.removerCliente(cpf);
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
            clientes = objectMapper.readValue(new File(ARQUIVO_CLIENTES), Cliente.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
