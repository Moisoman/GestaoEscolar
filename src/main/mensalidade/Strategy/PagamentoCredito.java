package org.example.mensalidade.Strategy;

public class PagamentoCredito implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via Cartão de Crédito.");
    }
}