package java.org.example.mensalidade.Strategy;

public class PagamentoDebito implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via Débito em Conta.");
    }
}