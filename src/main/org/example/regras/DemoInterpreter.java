package org.example.regras;


import org.example.regras.expressao.Expressao;
import org.example.regras.expressao.MultiplicacaoExpressao;
import org.example.regras.expressao.NumeroExpressao;
import org.example.regras.expressao.SomaExpressao;
import org.example.regras.expressao.VariavelExpressao;

/**
 * Cliente (Client) Standalone para demonstrar o padrão Interpreter.
 * O cliente constrói a "frase" (a regra de negócio) como uma
 * Árvore de Sintaxe Abstrata (AST).
 */
public class DemoInterpreter {

    public static void main(String[] args) {
        System.out.println("### Demonstração: Interpreter (Regras de Aprovação) ###");

        // --- 1. O CONTEXTO ---
        // Define as notas do aluno (o "ambiente" de execução)
        ContextoAvaliacao contextoAluno = new ContextoAvaliacao();
        contextoAluno.setVariavel("P1", 8.0);
        contextoAluno.setVariavel("P2", 7.0);
        contextoAluno.setVariavel("TRABALHO", 9.0);

        
        // --- 2. A REGRA (A "Frase" da Linguagem) ---
        // O cliente constrói a regra: (P1 * 0.4) + (P2 * 0.6)
        
        System.out.println("\n--- Regra 1: Média Ponderada (P1*0.4) + (P2*0.6) ---");
        
        // Parte 1: (P1 * 0.4)
        Expressao p1 = new VariavelExpressao("P1");
        Expressao peso1 = new NumeroExpressao(0.4);
        Expressao mult1 = new MultiplicacaoExpressao(p1, peso1);

        // Parte 2: (P2 * 0.6)
        Expressao p2 = new VariavelExpressao("P2");
        Expressao peso2 = new NumeroExpressao(0.6);
        Expressao mult2 = new MultiplicacaoExpressao(p2, peso2);

        // Parte Final: (Parte 1) + (Parte 2)
        Expressao regraPonderada = new SomaExpressao(mult1, mult2);
        
        // --- 3. A INTERPRETAÇÃO ---
        // O cliente pede para a regra se "interpretar"
        double mediaFinal = regraPonderada.interpretar(contextoAluno);

        System.out.println("Resultado do Cálculo da Regra 1: " + mediaFinal);
        if (mediaFinal >= 6.0) {
            System.out.println("Status: APROVADO (Média >= 6.0)");
        } else {
            System.out.println("Status: REPROVADO (Média < 6.0)");
        }


        // --- 4. A FLEXIBILIDADE ---
        // Agora, o cliente constrói OUTRA REGRA sem mudar o interpretador.
        // Regra: (P1 + TRABALHO)
        // (Não precisamos do /2, só queremos a soma das notas)
        System.out.println("\n--- Regra 2: Pontos da Prova 1 + Trabalho ---");
        
        Expressao regraSomaSimples = new SomaExpressao(
            new VariavelExpressao("P1"),
            new VariavelExpressao("TRABALHO")
        );
        
        double pontos = regraSomaSimples.interpretar(contextoAluno);
        System.out.println("Resultado do Cálculo da Regra 2: " + pontos);
    }
}