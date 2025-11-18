package org.example.professores.Composite;

import org.example.entities.Professor;

public class CompositeService {
    public static void main(String[] args) {
        Professor professor1 = new ProfessorIndividual("João", "Matemática");
        Professor professor2 = new ProfessorIndividual("Maria", "Física");
        Professor professor3 = new ProfessorIndividual("Pedro", "Química");

        ProfessoresComposite grupo1 = new ProfessoresComposite();
        grupo1.adicionarProfessor(professor1);
        grupo1.adicionarProfessor(professor2);

        ProfessoresComposite grupo2 = new ProfessoresComposite();
        grupo2.adicionarProfessor(professor3);

        ProfessoresComposite grupoPrincipal = new ProfessoresComposite();
        grupoPrincipal.adicionarProfessor(grupo1);  // Adiciona o grupo 1
        grupoPrincipal.adicionarProfessor(grupo2);  // Adiciona o grupo 2

        System.out.println("Professor 1:");
        professor1.mostrarInformacoes();
        System.out.println("\n");

        System.out.println("Professor 2:");
        professor2.mostrarInformacoes();
        System.out.println("\n");

        System.out.println("Professor 3:");
        professor3.mostrarInformacoes();
        System.out.println("\n");

        System.out.println("Grupo 1:");
        grupo1.mostrarInformacoes();

        System.out.println("Grupo 2:");
        grupo2.mostrarInformacoes();

        System.out.println("Grupo Principal:");
        grupoPrincipal.mostrarInformacoes();
    }
}
