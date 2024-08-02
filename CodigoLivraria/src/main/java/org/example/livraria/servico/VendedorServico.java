package org.example.livraria.servico;

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

    public VendedorServico (){
        if (PersistenciaUtil.arquivoExiste(ARQUIVO_VENDEDORES)){
            vendedores.adicionarListaDeVendedores(PersistenciaUtil.desserealizarLista(ARQUIVO_VENDEDORES));
        }
        else {
            vendedores = new Vendedor();
        }
    }

    public List<Vendedor> retornaVendedores() {
        return vendedores.getVendedores();
    }

    public Vendedor adicionaVendedor(Vendedor vendedor) {
        vendedores.adicionarVendedor(vendedor);
        PersistenciaUtil.serializaLista(vendedores.getVendedores(), ARQUIVO_VENDEDORES);
        return vendedor;
    }

}
