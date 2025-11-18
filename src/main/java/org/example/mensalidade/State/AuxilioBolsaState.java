package java.org.example.mensalidade.State;

public class AuxilioBolsaState implements EstadoBolsa {
    @Override
    public void mostrarTipo() {
        System.out.println("Bolsa Remuneração: Auxílio para alunos estrangeiros (valor parcial para custos adicionais)");
    }

    @Override
    public double calcularValorBolsa() {
        return 300;
    }
}
