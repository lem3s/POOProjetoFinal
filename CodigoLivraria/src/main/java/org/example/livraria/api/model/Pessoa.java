package org.example.livraria.api.model;

import java.io.Serializable;

/**
 * Classe base para as outras que precisam das informações de uma pessoa
 */
public abstract class Pessoa implements Serializable {
    private String nome;
    private String cpf;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
