package org.example.recursos.factory;

import org.example.recursos.produtos.AplicativoOnline;
import org.example.recursos.produtos.Apostila;


// A interface da Abstract Factory
public interface MaterialDidaticoFactory {
    Apostila criarApostila();
    AplicativoOnline criarAplicativo();
}