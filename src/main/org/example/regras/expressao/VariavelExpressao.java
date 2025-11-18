package org.example.regras.expressao;

import org.example.regras.ContextoAvaliacao;

/**
 * TerminalExpression (Expressão Terminal):
 * Representa uma variável (ex: "P1").
 */
public class VariavelExpressao implements Expressao {
    private String nomeVariavel;

    public VariavelExpressao(String nomeVariavel) {
        this.nomeVariavel = nomeVariavel;
    }

    @Override
    public double interpretar(ContextoAvaliacao contexto) {
        // Busca o valor da variável dentro do contexto
        return contexto.getValor(this.nomeVariavel);
    }
}