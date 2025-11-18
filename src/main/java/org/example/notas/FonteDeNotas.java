// Pacote: gestaoescolar.notas
package java.org.example.notas;

/**
 * Target (Alvo): A interface que o nosso novo sistema (Cliente) espera.
 * O cliente quer um simples array de doubles.
 */
public interface FonteDeNotas {
    double[] getNotas(String idAluno);
}