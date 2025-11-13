package org.example.mensalidade.Bridge;

public class CalculoComDesconto implements CalculoMensalidade {
    private double desconto;

    public CalculoComDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double calcularMensalidade(double valorBase) {
        return valorBase - (valorBase * desconto / 100);
    }
}
