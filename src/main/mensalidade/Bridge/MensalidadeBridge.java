package org.example.mensalidade.Bridge;

import org.example.entities.Mensalidade;
import org.example.entities.interfaces.CalculoMensalidade;

/**
 * Visa desacoplar uma abstração de sua implementação,
 * permitindo que ambas evoluam independentemente.
 * Separar a abstração do concreto
 */
public class MensalidadeBridge extends Mensalidade {
    private double valorBase;

    public MensalidadeBridge(double valorBase, CalculoMensalidade calculoMensalidade, ExibicaoMensalidade exibicaoMensalidade) {
        super(calculoMensalidade, exibicaoMensalidade);
        this.valorBase = valorBase;
    }

    @Override
    public void mostrarMensalidade() {
        double valorFinal = calculoMensalidade.calcularMensalidade(valorBase);

        exibicaoMensalidade.exibirMensalidade(valorFinal);
    }
}
