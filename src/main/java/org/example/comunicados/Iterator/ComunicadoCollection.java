package java.org.example.comunicados.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Armazena uma coleção de comunicados, escondendo a estrutura interna e fornece o metodo iterator
 * que irá percorrer todos os comunicados e apresentar no output do sistema
 */
public class ComunicadoCollection {
    private List<Comunicado> comunicados;

    public ComunicadoCollection() {
        comunicados = new ArrayList<>();
    }

    public void adicionarComunicado(Comunicado comunicado) {
        comunicados.add(comunicado);
    }

    public Iterator getIterator() {
        return new ComunicadoIterator(comunicados);
    }
}