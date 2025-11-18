package org.example.mensalidade.State;

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
