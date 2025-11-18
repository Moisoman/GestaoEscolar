package org.example.regras.expressao;

import org.example.regras.ContextoAvaliacao;

/**
 * AbstractExpression (Expressão Abstrata):
 * A interface para todas as expressões (terminais ou não).
 */
public interface Expressao {
    /**
     * Interpreta a expressão dado um contexto.
     * @param contexto Os valores das variáveis (P1, P2, etc.)
     * @return O resultado numérico da expressão.
     */
    double interpretar(ContextoAvaliacao contexto);
}