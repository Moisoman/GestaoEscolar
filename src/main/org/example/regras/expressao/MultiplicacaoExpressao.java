package org.example.regras.expressao;

import org.example.regras.ContextoAvaliacao;

/**
 * NonTerminalExpression (Expressão Não-Terminal):
 * Representa uma operação de Multiplicação.
 */
public class MultiplicacaoExpressao implements Expressao {
    private Expressao esquerda;
    private Expressao direita;

    public MultiplicacaoExpressao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public double interpretar(ContextoAvaliacao contexto) {
        // Interpreta os dois lados e multiplica os resultados
        return esquerda.interpretar(contexto) * direita.interpretar(contexto);
    }
}