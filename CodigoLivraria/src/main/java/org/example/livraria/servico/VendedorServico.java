package org.example.livraria.servico;

import com.fasterxml.jackson.core.type.TypeReference;
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
    private static final String ARQUIVO_VENDEDORES = "vendedores.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Vendedor> vendedores;

    public VendedorServico() {
        vendedores = new ArrayList<Vendedor>();

        if (PersistenciaUtil.arquivoExiste(ARQUIVO_VENDEDORES)) {
            carregaVendedores();
        }
    }

    public List<Vendedor> retornaVendedores() { return vendedores; }

    public Vendedor adicionaVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
        salvaVendedores();

        return vendedor;
    }

    public boolean removeVendedor(String cpf) {
        for (Vendedor _vendedor : vendedores) {
            if (_vendedor.getcpf().equals(cpf)) {
                vendedores.remove(_vendedor);
                return true;
            }
        }
        return false;
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
            vendedores = objectMapper.readValue(new java.io.File(ARQUIVO_VENDEDORES), new TypeReference<List<Vendedor>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
