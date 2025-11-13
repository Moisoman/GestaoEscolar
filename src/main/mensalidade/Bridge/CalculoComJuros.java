package org.example.mensalidade.Bridge;

public class CalculoComJuros implements CalculoMensalidade {
    private double juros;

    public CalculoComJuros(double juros) {
        this.juros = juros;
    }

    @Override
    public double calcularMensalidade(double valorBase) {
        return valorBase + (valorBase * juros / 100);
    }
}
