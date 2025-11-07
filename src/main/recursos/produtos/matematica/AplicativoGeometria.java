package produtos.matematica;

import produtos.AplicativoOnline;

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