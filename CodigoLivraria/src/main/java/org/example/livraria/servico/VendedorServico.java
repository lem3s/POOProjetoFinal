package org.example.livraria.servico;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.livraria.api.model.Estoque;
import org.example.livraria.api.model.Livro;
import org.example.livraria.api.model.NotaFiscal;
import org.example.livraria.api.model.Vendedor;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendedorServico {
    private static final String ARQUIVO_VENDEDORES = "vendedores.ser";
    private ObjectMapper objectMapper;
    private Vendedor vendedores;

    public VendedorServico() {
        objectMapper = new ObjectMapper();
        if (PersistenciaUtil.arquivoExiste(ARQUIVO_VENDEDORES)) {
            carregaVendedores();
        }
    }

    public List<Vendedor> retornaVendedores() { return vendedores.getVendedores(); }

    public Vendedor adicionaVendedor(Vendedor vendedor) {
        vendedor.adicionarVendedor(vendedores);
        salvaVendedores();
        return vendedor;
    }

    public boolean removeVendedor(String cpf) {
        return vendedores.removerVendedor(cpf);
    }

    public void salvaVendedores() {
        try {
            objectMapper.writeValue(new java.io.File(ARQUIVO_VENDEDORES), vendedores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregaVendedores() {
        try {
            vendedores = objectMapper.readValue(new java.io.File(ARQUIVO_VENDEDORES), Vendedor.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
