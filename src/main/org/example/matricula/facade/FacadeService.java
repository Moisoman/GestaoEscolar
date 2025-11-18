package org.example.matricula.facade;

/**
 * Cliente (Client) Standalone para demonstrar o padrão Facade.
 * * Para executar:
 * 1. Compile todos os 5 arquivos.
 * 2. Execute este arquivo (DemoFacade.java).
 */
public class FacadeService  {

    public static void main(String[] args) {
        System.out.println("### Demonstração: Facade (Standalone) ###");
        System.out.println("O Cliente (este main) só conhece a classe MatriculaFacade.");
        
        // 1. O cliente instancia APENAS a fachada
        MatriculaFacade facade = new MatriculaFacade();
        
        // --- Teste 1: Matrícula com Sucesso ---
        System.out.println("\n--- 1. Tentativa de Matrícula (Sucesso) ---");
        String nome1 = "Ana Souza";
        String cpf1 = "987.654.321-00";
        String turma1 = "TURMA-101";
        
        // 2. O cliente faz UMA ÚNICA chamada
        boolean sucesso1 = facade.realizarMatricula(nome1, cpf1, turma1);
        System.out.println("Status da Matrícula 1: " + (sucesso1 ? "OK" : "FALHA"));
        
        
        // --- Teste 2: Tentativa de Matrícula (Falha por Duplicidade) ---
        System.out.println("\n--- 2. Tentativa de Matrícula (Falha por Duplicidade) ---");
        String nome2 = "Pedro Martins";
        String cpf2 = "987.654.321-00"; // <-- MESMO CPF da Ana
        String turma2 = "TURMA-102";
        
        // 3. O cliente faz a MESMA chamada
        boolean sucesso2 = facade.realizarMatricula(nome2, cpf2, turma2);
        System.out.println("Status da Matrícula 2: " + (sucesso2 ? "OK" : "FALHA"));
    }
}