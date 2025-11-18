package java.org.example.mensalidade.Strategy;

public class PagamentoContext {
    private PagamentoStrategy estrategiaDePagamento;

    public void setEstrategiaDePagamento(PagamentoStrategy estrategia) {
        this.estrategiaDePagamento = estrategia;
    }

    public void realizarPagamento(double valor) {
        if (estrategiaDePagamento == null) {
            System.out.println("Nenhuma forma de pagamento definida.");
        } else {
            estrategiaDePagamento.pagar(valor);
        }
    }
}
