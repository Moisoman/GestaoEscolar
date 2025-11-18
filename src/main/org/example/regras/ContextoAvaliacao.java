package org.example.regras;

import java.util.HashMap;
import java.util.Map;

/**
 * Context (Contexto): Armazena os valores das variáveis
 * (ex: P1, P2, TRABALHO) para uma execução específica.
 */
public class ContextoAvaliacao {
    
    private Map<String, Double> variaveis = new HashMap<>();

    public void setVariavel(String nome, double valor) {
        variaveis.put(nome.toUpperCase(), valor);
        System.out.println("[Contexto] Definindo variável: " + nome.toUpperCase() + " = " + valor);
    }

    public double getValor(String nome) {
        if (!variaveis.containsKey(nome.toUpperCase())) {
            System.err.println("[Contexto] ERRO: Variável '" + nome + "' não definida.");
            return 0; // Retorna 0 se a nota não foi lançada
        }
        return variaveis.get(nome.toUpperCase());
    }
}