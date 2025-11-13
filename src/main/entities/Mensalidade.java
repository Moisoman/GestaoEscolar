package org.example.entities;

import org.example.entities.interfaces.CalculoMensalidade;
import org.example.mensalidade.Bridge.ExibicaoMensalidade;

public abstract class Mensalidade {
    protected CalculoMensalidade calculoMensalidade;
    protected ExibicaoMensalidade exibicaoMensalidade;

    // Construtor recebe o cálculo e a exibição
    public Mensalidade(CalculoMensalidade cálculoMensalidade, ExibicaoMensalidade exibicaoMensalidade) {
        this.calculoMensalidade = cálculoMensalidade;
        this.exibicaoMensalidade = exibicaoMensalidade;
    }

    // Método para calcular e exibir a mensalidade
    public abstract void mostrarMensalidade();
}
