package java.org.example.mensalidade.State;

/**
 * É usado para os objetos que podem ter diferentes estados,
 * e o comportamento do objeto muda conforme seu estado
 * no exemplo de bolsas:
 */
public class BolsaState {
    private EstadoBolsa estadoBolsa;

    public BolsaState() {
        this.estadoBolsa = new MeiaBolsaState();
    }

    public void setEstadoBolsa(EstadoBolsa estadoBolsa) {
        this.estadoBolsa = estadoBolsa;
    }

    public void mostrarTipo() {
        estadoBolsa.mostrarTipo();
    }

    public double calcularValorBolsa() {
        return estadoBolsa.calcularValorBolsa();
    }
}
