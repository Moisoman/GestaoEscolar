package java.org.example.mensalidade.State;

public class StateService {
    public static void main(String[] args) {
        BolsaState bolsa = new BolsaState();

        bolsa.mostrarTipo();
        System.out.println("Valor da bolsa: R$ " + bolsa.calcularValorBolsa());

        bolsa.setEstadoBolsa(new IntegralBolsaState());
        bolsa.mostrarTipo();
        System.out.println("Valor da bolsa: R$ " + bolsa.calcularValorBolsa());

        bolsa.setEstadoBolsa(new AuxilioBolsaState());
        bolsa.mostrarTipo();
        System.out.println("Valor da bolsa: R$ " + bolsa.calcularValorBolsa());

        bolsa.setEstadoBolsa(new EstagioBolsaState());
        bolsa.mostrarTipo();
        System.out.println("Valor da bolsa: R$ " + bolsa.calcularValorBolsa());

        bolsa.setEstadoBolsa(new ExtensaoBolsaState());
        bolsa.mostrarTipo();
        System.out.println("Valor da bolsa: R$ " + bolsa.calcularValorBolsa());
    }
}
