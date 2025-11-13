package org.example.recursos.produtos.historia;


import org.example.recursos.produtos.AplicativoOnline;

// Pacote: gestaoescolar.recursos.produtos.historia
public class AplicativoMapaHistorico implements AplicativoOnline {
    @Override
    public String getNome() {
        return "App Atlas do Tempo";
    }

    @Override
    public String getUrlAcesso() {
        return "https://escola.com/apps/atlasdotempo";
    }
}