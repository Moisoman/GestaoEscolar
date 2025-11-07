package produtos.historia;

import produtos.AplicativoOnline;

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