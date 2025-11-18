
package java.org.example.notas.legado;

import java.util.HashMap;
import java.util.Map;

/**
 * Adaptee (Adaptado): A classe legada (sistema antigo).
 * Não podemos alterar este código.
 * Ele retorna as notas em um formato incompatível.
 */
public class SistemaDeNotasAntigo {

    // Simula a busca no banco de dados legado
    public Map<String, String> buscarNotasLegado(String idAluno) {
        System.out.println("[Legado] Buscando notas no sistema antigo para o aluno: " + idAluno);
        Map<String, String> notasMap = new HashMap<>();
        
        // O sistema antigo retorna as notas como String!
        if (idAluno.equals("A123")) {
            notasMap.put("P1", "8.5");
            notasMap.put("P2", "7.0");
            notasMap.put("Trabalho", "9.5");
        } else {
            notasMap.put("P1", "5.0");
            notasMap.put("P2", "6.5");
        }
        return notasMap;
    }
}