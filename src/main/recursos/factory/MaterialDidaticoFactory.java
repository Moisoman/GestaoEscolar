package factory;

// Pacote: gestaoescolar.recursos.factory
import produtos.Apostila;
import produtos.AplicativoOnline;

// A interface da Abstract Factory
public interface MaterialDidaticoFactory {
    Apostila criarApostila();
    AplicativoOnline criarAplicativo();
}