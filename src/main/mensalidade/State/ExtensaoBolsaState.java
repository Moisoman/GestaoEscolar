package org.example.mensalidade.State;

import org.example.entities.interfaces.EstadoBolsa;

public class ExtensaoBolsaState implements EstadoBolsa {
    @Override
    public void mostrarTipo() {
        System.out.println("Bolsa Remuneração: Extensão para Alunos do Ensino Médio (para atividades extracurriculares)");
    }

    @Override
    public double calcularValorBolsa() {
        return 700;
    }
}
