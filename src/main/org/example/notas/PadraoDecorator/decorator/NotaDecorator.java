
package org.example.notas.PadraoDecorator.decorator;

import org.example.notas.PadraoDecorator.Avaliacao;

/**
 * Decorator (Decorador Abstrato):
 * Implementa a interface Component e mantém uma referência
 * para o objeto Component que ele "envolve".
 */
public abstract class NotaDecorator implements Avaliacao {

    // Referência para o objeto "embrulhado" (pode ser
    // uma NotaBase ou outro Decorator)
    protected Avaliacao avaliacaoBase;

    public NotaDecorator(Avaliacao avaliacaoBase) {
        this.avaliacaoBase = avaliacaoBase;
    }

    /**
     * Por padrão, o decorator delega a chamada para
     * o objeto que ele envolve.
     */
    @Override
    public double calcularNota() {
        return avaliacaoBase.calcularNota();
    }

    /**
     * Delega a descrição também.
     */
    @Override
    public String getDescricao() {
        return avaliacaoBase.getDescricao();
    }
}