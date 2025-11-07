package factory;

// Pacote: gestaoescolar.recursos.factory
import produtos.Apostila;
import produtos.AplicativoOnline;
import produtos.matematica.ApostilaCalculo;
import produtos.matematica.AplicativoGeometria;

// Fábrica Concreta para Matemática
public class MatematicaFactory implements MaterialDidaticoFactory {
    @Override
    public Apostila criarApostila() {
        // Garante que a apostila é de matemática
        return new ApostilaCalculo();
    }

    @Override
    public AplicativoOnline criarAplicativo() {
        // Garante que o app é de matemática
        return new AplicativoGeometria();
    }
}