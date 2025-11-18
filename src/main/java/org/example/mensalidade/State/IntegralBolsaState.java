package java.org.example.mensalidade.State;

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
