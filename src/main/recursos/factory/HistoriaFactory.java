package factory;

import produtos.Apostila;
import produtos.AplicativoOnline;
import produtos.historia.ApostilaHistoriaAntiga;
import produtos.historia.AplicativoMapaHistorico;

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