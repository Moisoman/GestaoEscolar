package org.example.regras.expressao;

import org.example.regras.ContextoAvaliacao;

/**
 * NonTerminalExpression (Expressão Não-Terminal):
 * Representa uma operação de Soma.
 */
public class SomaExpressao implements Expressao {
    private Expressao esquerda;
    private Expressao direita;

    public SomaExpressao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public double interpretar(ContextoAvaliacao contexto) {
        // Interpreta os dois lados e soma os resultados
        return esquerda.interpretar(contexto) + direita.interpretar(contexto);
    }
}