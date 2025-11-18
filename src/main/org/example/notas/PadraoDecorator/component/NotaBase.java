package org.example.notas.PadraoDecorator.component;

import org.example.notas.PadraoDecorator.Avaliacao;

/**
 * ConcreteComponent (Componente Concreto): O objeto original
 * que armazena a nota básica de uma prova ou trabalho.
 */
public class NotaBase implements Avaliacao {

    private double valor;

    public NotaBase(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularNota() {
        return this.valor;
    }

    @Override
    public String getDescricao() {
        return "Nota Base (" + this.valor + ")";
    }
}
