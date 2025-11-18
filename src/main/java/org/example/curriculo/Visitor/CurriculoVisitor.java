package java.org.example.curriculo.Visitor;

import java.org.example.entities.Curriculo;

/**
 * Esse padrão serve para separar a lógica de operações sobre uma
 * estrutura de objetos complexa,
 * permitindo que você adicione novas operações sem alterar
 * as classes dos objetos sobre os quais elas operam.
 */
public interface CurriculoVisitor {
    void visitar(Curriculo curriculo);
}
