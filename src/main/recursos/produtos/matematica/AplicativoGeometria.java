package org.example.recursos.produtos.matematica;


import org.example.recursos.produtos.AplicativoOnline;

// Pacote: gestaoescolar.recursos.produtos.matematica
public class AplicativoGeometria implements AplicativoOnline {
    @Override
    public String getNome() {
        return "App GeoSolver 3D";
    }

    @Override
    public String getUrlAcesso() {
        return "https://escola.com/apps/geosolver";
    }
}