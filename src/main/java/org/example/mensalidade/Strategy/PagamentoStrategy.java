package java.org.example.mensalidade.Strategy;

/**
 * Padrão de projeto ideal para quando se tem algoritimos, ou
 * estratégias que podem ser trocadas dinamicamente
 * nesse caso será opções de pagamento
 */
public interface PagamentoStrategy {
    void pagar(double valor);
}