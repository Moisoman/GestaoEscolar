package org.example.mensalidade.State;

import org.example.entities.interfaces.EstadoBolsa;

public class IntegralBolsaState implements EstadoBolsa {
    @Override
    public void mostrarTipo() {
        System.out.println("Bolsa Desconto: Integral para alunos do Ensino Fundamental (100% de desconto)");
    }

    @Override
    public double calcularValorBolsa() {
        return 0;
    }
}
