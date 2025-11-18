package org.example.mensalidade.Bridge;

import org.example.entities.Mensalidade;

public class MensalidadeService {
    public static void main(String[] args) {
        CalculoMensalidade calculoComDesconto = new CalculoComDesconto(10);  // 10% de desconto
        CalculoMensalidade calculoComJuros = new CalculoComJuros(5);  // 5% de juros
        ExibicaoMensalidade exibicaoTexto = new ExibicaoTexto();
        ExibicaoMensalidade exibicaoPDF = new ExibicaoPDF();


        Mensalidade mensalidadeComDescontoTexto = new MensalidadeBridge(500, calculoComDesconto, exibicaoTexto);
        Mensalidade mensalidadeComJurosPDF = new MensalidadeBridge(500, calculoComJuros, exibicaoPDF);


        System.out.println("Mensalidade com Desconto em Texto:");
        mensalidadeComDescontoTexto.mostrarMensalidade();

        System.out.println("\nMensalidade com Juros em PDF:");
        mensalidadeComJurosPDF.mostrarMensalidade();
    }
}
