package java.org.example.comunicados.Iterator;

import java.util.List;

/**
 * Permite percorrer uma coleção de objetos (por exemplo, uma lista, conjunto, etc.)
 * sem expor sua estrutura interna.
 * Em vez de acessar diretamente os elementos da coleção,
 * o Iterator oferece uma maneira padronizada de navegar pelos elementos sequencialmente.
 */
public class ComunicadoIterator implements Iterator {
    private List<Comunicado> comunicados;
    private int indice;

    public ComunicadoIterator(List<Comunicado> comunicados) {
        this.comunicados = comunicados;
        this.indice = 0;
    }

    @Override
    public boolean hasNext() {
        return indice < comunicados.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return comunicados.get(indice++);
        }
        return null;
    }
}
