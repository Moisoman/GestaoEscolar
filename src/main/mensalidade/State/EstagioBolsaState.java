package org.example.mensalidade.State;

import org.example.entities.interfaces.EstadoBolsa;

public class EstagioBolsaState implements EstadoBolsa {
    @Override
    public void mostrarTipo() {
        System.out.println("Bolsa Remuneração: Estágio para alunos do Ensino Técnico");
    }

    @Override
    public double calcularValorBolsa() {
        return 1119.95;
    }
}
