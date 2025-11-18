package org.example.notas.PadraoDecorator.decorator;

import org.example.notas.PadraoDecorator.Avaliacao;

/**
 * ConcreteDecorator (Decorador Concreto)
 * Adiciona o bônus de comportamento.
 */
public class NotaBonusComportamento extends NotaDecorator {

    private final double BONUS = 0.5;

    public NotaBonusComportamento(Avaliacao avaliacaoBase) {
        super(avaliacaoBase);
    }

    /**
     * Sobrescreve o método para adicionar a nova funcionalidade.
     */
    @Override
    public double calcularNota() {
        // 1. Pega a nota da base (o que estava "embrulhado")
        double notaAnterior = super.calcularNota();
        
        // 2. Adiciona o bônus
        double notaFinal = notaAnterior + BONUS;
        
        System.out.println("[Decorator] Adicionando bônus de comportamento: +" + BONUS);
        return notaFinal;
    }

    @Override
    public String getDescricao() {
        // "Empilha" a descrição
        return super.getDescricao() + " + Bônus Comportamento (" + BONUS + ")";
    }
}