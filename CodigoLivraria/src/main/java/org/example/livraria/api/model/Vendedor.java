package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.List;

public class Vendedor extends Pessoa implements Serializable {
    private double salario;
    private List<Vendedor> vendedores;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getcpf() { return getCpf(); }

    public String getNome() { return super.getNome(); }

    public String getTelefone() { return super.getTelefone(); }

    public boolean removerVendedor(String cpf) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getcpf() == cpf) {
                vendedores.remove(vendedor);
                return true;
            }
        }
        return false;
    }

    public void adicionarVendedor(Vendedor vendedor) { vendedores.add(vendedor); }

    public List<Vendedor> getVendedores() { return vendedores; }
}
