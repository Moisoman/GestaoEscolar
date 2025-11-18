package java.org.example.mensalidade.Bridge;

public class ExibicaoTexto implements ExibicaoMensalidade {
    @Override
    public void exibirMensalidade(double valor) {
        System.out.println("Valor da mensalidade: R$ " + valor);
    }
}
