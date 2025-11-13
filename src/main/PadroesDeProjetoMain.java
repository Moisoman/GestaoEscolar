package org.example;


import org.example.alunos.AlunosObserver;
import org.example.alunos.NotificarAlunos;
import org.example.alunos.Observer;

public class PadroesDeProjetoMain {
    public static void main(String[] args) {
        // Demonstrando o padrão Observer
        demonstrarObserver();

//        // Demonstrando o padrão Singleton
//        demonstrarSingleton();
//
//        // Demonstrando o padrão Factory
//        demonstrarFactory();

        // E assim por diante para os outros padrões...
    }

    private static void demonstrarObserver() {
        AlunosObserver alunosObserver = new AlunosObserver();

        Observer aluno1 = new NotificarAlunos("João");
        Observer aluno2 = new NotificarAlunos("Maria");
        Observer aluno3 = new NotificarAlunos("Pedro");

        alunosObserver.addObserver(aluno1);
        alunosObserver.addObserver(aluno2);
        alunosObserver.addObserver(aluno3);

        alunosObserver.setMensagem("Aulas serão remarcadas para amanhã!");

        alunosObserver.removeObserver(aluno1);

        alunosObserver.setMensagem("Resultado de provas foi publicado!");
    }

    }

//    private static void demonstrarSingleton() {
//
//    }
//
//    private static void demonstrarFactory() {
//
//    }

    // Adicione métodos para cada um dos padrões...

