package org.example.notas.PadraoDecorator;

/**
 * Component (Componente): A interface comum para
 * a nota base e todos os decoradores.
 */
public interface Avaliacao {
    /**
     * Calcula o valor final da nota.
     * @return a nota calculada.
     */
    double calcularNota();

    /**
     * Obtém a descrição da composição da nota.
     * @return a descrição.
     */
    String getDescricao();
}
