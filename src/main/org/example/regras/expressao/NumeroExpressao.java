package org.example.regras.expressao;

import org.example.regras.ContextoAvaliacao;

/**
 * TerminalExpression (Expressão Terminal):
 * Representa um número constante (ex: 0.4).
 */
public class NumeroExpressao implements Expressao {
    private double valor;

    public NumeroExpressao(double valor) {
        this.valor = valor;
    }

    @Override
    public double interpretar(ContextoAvaliacao contexto) {
        // Simplesmente retorna seu próprio valor
        return this.valor;
    }
}