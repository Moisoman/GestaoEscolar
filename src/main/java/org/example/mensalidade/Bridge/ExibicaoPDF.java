package java.org.example.mensalidade.Bridge;

public class ExibicaoPDF implements ExibicaoMensalidade {
    @Override
    public void exibirMensalidade(double valor) {
        System.out.println("Gerando PDF...");
        System.out.println("Valor da mensalidade: R$ " + valor);
    }
}
