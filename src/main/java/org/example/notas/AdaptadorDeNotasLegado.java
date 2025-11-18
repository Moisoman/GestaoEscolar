
package java.org.example.notas;

import java.org.example.notas.legado.SistemaDeNotasAntigo;

import java.util.Map;

/**
 * Adapter (Adaptador): A classe que faz a "tradução".
 * 1. Implementa a interface nova (Target).
 * 2. "Envolve" (wraps) a classe antiga (Adaptee).
 */
public class AdaptadorDeNotasLegado implements FonteDeNotas {

    // 2. Contém uma instância do sistema legado (Adaptee)
    private SistemaDeNotasAntigo sistemaAntigo;

    public AdaptadorDeNotasLegado() {
        this.sistemaAntigo = new SistemaDeNotasAntigo();
    }

    /**
     * 1. Implementa o método da interface nova (Target)
     */
    @Override
    public double[] getNotas(String idAluno) {
        System.out.println("[Adapter] Requisição recebida. Chamando sistema legado...");
        
        // Chama o método incompatível do sistema antigo
        Map<String, String> notasMap = sistemaAntigo.buscarNotasLegado(idAluno);

        // --- AQUI ACONTECE A TRADUÇÃO ---
        System.out.println("[Adapter] Traduzindo Map<String, String> para double[]...");
        
        double[] notasArray = new double[notasMap.size()];
        int i = 0;
        for (String notaString : notasMap.values()) {
            try {
                // Converte a String para double
                notasArray[i] = Double.parseDouble(notaString);
                i++;
            } catch (NumberFormatException e) {
                System.err.println("[Adapter] Erro ao traduzir nota: " + notaString);
                notasArray[i] = 0.0; // Valor padrão em caso de erro
                i++;
            }
        }
        
        System.out.println("[Adapter] Tradução concluída.");
        return notasArray; // Retorna no formato que o cliente espera
    }
}