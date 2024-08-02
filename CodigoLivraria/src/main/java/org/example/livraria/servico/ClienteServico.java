package org.example.livraria.servico;

import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServico {
    private static final String ARQUIVO_CLIENTES = "clientes.ser";

    public ClienteServico (){
        if (PersistenciaUtil.arquivoExiste(ARQUIVO_CLIENTES)){
            clientes.adicionarListaDeClientes(PersistenciaUtil.desserealizarLista(ARQUIVO_CLIENTES));
        }
        else {
            clientes = new Cliente();
        }
    }

    public List<Cliente> retornaClientes() {
        return clientes.getClientes();
    }

    public Cliente adicionaCliente(Cliente cliente) {
        clientes.adicionarCliente(cliente);
        PersistenciaUtil.serializaLista(clientes.getClientes(), ARQUIVO_CLIENTES);
        return cliente;
    }
}
