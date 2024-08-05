package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.List;

/**
 * As informações do vendedor
 */
public class Vendedor extends Pessoa implements Serializable {
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getcpf() { return super.getCpf(); }

    public String getNome() { return super.getNome(); }

    public String getTelefone() { return super.getTelefone(); }
}
