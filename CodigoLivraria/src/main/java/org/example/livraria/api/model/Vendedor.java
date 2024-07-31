package org.example.livraria.api.model;

import java.io.Serializable;

public class Vendedor extends Pessoa implements Serializable {
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
