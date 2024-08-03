package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Serializable {
    private String endereco;
    private List<LivroNotaFiscal> notasFiscais = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<LivroNotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(List<LivroNotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

    public boolean removerCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getcpf() == cpf) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public void adicionarCliente(Cliente cliente) { clientes.add(cliente); }

    public List<Cliente> getClientes() { return clientes; }

    public String getcpf() { return getCpf(); }
}