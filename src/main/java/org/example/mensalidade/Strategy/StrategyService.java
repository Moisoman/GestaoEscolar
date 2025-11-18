package java.org.example.mensalidade.Strategy;

public class StrategyService {
    public static void main(String[] args) {
        PagamentoContext contextoPagamento = new PagamentoContext();

        contextoPagamento.setEstrategiaDePagamento(new PagamentoBoleto());
        contextoPagamento.realizarPagamento(150.00);

        contextoPagamento.setEstrategiaDePagamento(new PagamentoDebito());
        contextoPagamento.realizarPagamento(250.00);

        contextoPagamento.setEstrategiaDePagamento(new PagamentoCredito());
        contextoPagamento.realizarPagamento(500.00);

        contextoPagamento.setEstrategiaDePagamento(new PagamentoPix());
        contextoPagamento.realizarPagamento(1000.00);
    }
}
