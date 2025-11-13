package org.example.recursos.factory;

// Pacote: gestaoescolar.recursos.factory

import org.example.recursos.produtos.AplicativoOnline;
import org.example.recursos.produtos.Apostila;

import org.example.recursos.produtos.matematica.AplicativoGeometria;
import org.example.recursos.produtos.matematica.ApostilaCalculo;


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