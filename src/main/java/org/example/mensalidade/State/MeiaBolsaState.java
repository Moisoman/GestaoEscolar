package java.org.example.mensalidade.State;

public class MeiaBolsaState implements EstadoBolsa {
    @Override
    public void mostrarTipo() {
        System.out.println("Bolsa Desconto: Meia Bolsa (disponível para todos os alunos)");
    }

    @Override
    public double calcularValorBolsa() {
        return 1000 * 0.5;
    }
}