package org.example.livraria.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Agregador de notas fiscais de venda
 */
public class NotaFiscal implements Serializable {
    List<LivroNotaFiscal> livrosComprados = new ArrayList<>();
    double valorTotalDoNotaFiscal;
}
