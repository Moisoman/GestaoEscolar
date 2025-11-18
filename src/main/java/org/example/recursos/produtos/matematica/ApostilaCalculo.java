package java.org.example.recursos.produtos.matematica;


import java.org.example.recursos.produtos.Apostila;

// Pacote: gestaoescolar.recursos.produtos.matematica
public class ApostilaCalculo implements Apostila {
    @Override
    public String getTitulo() {
        return "Apostila de Cálculo Diferencial e Integral";
    }

    @Override
    public String getConteudo() {
        return "Conteúdo sobre Limites, Derivadas e Integrais...";
    }
}