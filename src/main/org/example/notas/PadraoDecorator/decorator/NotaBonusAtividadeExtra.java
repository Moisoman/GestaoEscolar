package org.example.notas.PadraoDecorator.decorator;

import org.example.notas.PadraoDecorator.Avaliacao;

/**
 * ConcreteDecorator (Decorador Concreto)
 * Adiciona o bônus de atividade extracurricular.
 */
public class NotaBonusAtividadeExtra extends NotaDecorator {

    private final double BONUS = 1.0;

    public NotaBonusAtividadeExtra(Avaliacao avaliacaoBase) {
        super(avaliacaoBase);
    }

    @Override
    public double calcularNota() {
        // 1. Pega a nota da base
        double notaAnterior = super.calcularNota();
        
        // 2. Adiciona o bônus
        double notaFinal = notaAnterior + BONUS;
        
        System.out.println("[Decorator] Adicionando bônus de atividade extra: +" + BONUS);
        return notaFinal;
    }

    @Override
    public String getDescricao() {
        // "Empilha" a descrição
        return super.getDescricao() + " + Bônus Atividade Extra (" + BONUS + ")";
    }
}