package java.org.example.recursos.factory;

import java.org.example.recursos.produtos.AplicativoOnline;
import java.org.example.recursos.produtos.Apostila;


// A interface da Abstract Factory
public interface MaterialDidaticoFactory {
    Apostila criarApostila();
    AplicativoOnline criarAplicativo();
}