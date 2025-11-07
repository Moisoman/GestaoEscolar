package produtos.historia;

import produtos.Apostila;

// Pacote: gestaoescolar.recursos.produtos.historia
public class ApostilaHistoriaAntiga implements Apostila {
    @Override
    public String getTitulo() {
        return "Apostila de História Antiga: Grécia e Roma";
    }

    @Override
    public String getConteudo() {
        return "Conteúdo sobre a democracia ateniense e o Império Romano...";
    }
}