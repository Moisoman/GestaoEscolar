package org.example.notas.PadraoDecorator;

import org.example.notas.PadraoDecorator.component.NotaBase;
import org.example.notas.PadraoDecorator.decorator.NotaBonusAtividadeExtra;
import org.example.notas.PadraoDecorator.decorator.NotaBonusComportamento;

/**
 * Cliente (Client) Standalone para demonstrar o padrão Decorator.
 * Mostra como "empilhar" funcionalidades dinamicamente.
 */
public class DemoDecorator {

    public static void main(String[] args) {
        System.out.println("### Demonstração: Decorator (Cálculo de Notas) ###");

        // --- Cenário 1: Aluno sem bônus ---
        System.out.println("\n--- 1. Aluno padrão (só a nota base) ---");
        Avaliacao notaAluno1 = new NotaBase(7.0);
        
        System.out.println("Descrição: " + notaAluno1.getDescricao());
        System.out.println("Nota Final: " + notaAluno1.calcularNota());

        
        // --- Cenário 2: Aluno com bônus de comportamento ---
        System.out.println("\n--- 2. Aluno com bônus de comportamento ---");
        // 1. Cria a nota base
        Avaliacao notaBaseAluno2 = new NotaBase(8.0);
        // 2. "Embrulha" a nota base com o decorador de comportamento
        Avaliacao notaAluno2 = new NotaBonusComportamento(notaBaseAluno2);
        
        System.out.println("Descrição: " + notaAluno2.getDescricao());
        System.out.println("Calculando...");
        System.out.println("Nota Final: " + notaAluno2.calcularNota());

        
        // --- Cenário 3: Aluno com bônus DUPLO (empilhado) ---
        System.out.println("\n--- 3. Aluno exemplar (todos os bônus) ---");
        
        // Criação "empilhada" (lida de dentro para fora):
        Avaliacao notaAluno3 = 
            new NotaBonusAtividadeExtra(       // 3. Embrulha com Atividade Extra
                new NotaBonusComportamento(    // 2. Embrulha com Comportamento
                    new NotaBase(7.5)          // 1. A nota base
                )
            );
        
        System.out.println("Descrição: " + notaAluno3.getDescricao());
        System.out.println("Calculando...");
        // O cálculo será chamado em cascata, de fora para dentro
        System.out.println("Nota Final: " + notaAluno3.calcularNota());
        
        
        // --- Cenário 4: Ordem de empilhamento diferente (mesmo resultado) ---
        System.out.println("\n--- 4. Aluno exemplar (ordem invertida) ---");
        Avaliacao notaAluno4 = 
            new NotaBonusComportamento(
                new NotaBonusAtividadeExtra(
                    new NotaBase(7.5)
                )
            );
        System.out.println("Descrição: " + notaAluno4.getDescricao());
        System.out.println("Calculando...");
        System.out.println("Nota Final: " + notaAluno4.calcularNota());
    }
}
