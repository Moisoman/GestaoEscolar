package org.example.recursos.factory;


import org.example.recursos.produtos.AplicativoOnline;
import org.example.recursos.produtos.Apostila;
import org.example.recursos.produtos.historia.AplicativoMapaHistorico;
import org.example.recursos.produtos.historia.ApostilaHistoriaAntiga;

// Fábrica Concreta para História
public class HistoriaFactory implements MaterialDidaticoFactory {
    @Override
    public Apostila criarApostila() {
        // Garante que a apostila é de história
        return new ApostilaHistoriaAntiga();
    }

    @Override
    public AplicativoOnline criarAplicativo() {
        // Garante que o app é de história
        return new AplicativoMapaHistorico();
    }
}