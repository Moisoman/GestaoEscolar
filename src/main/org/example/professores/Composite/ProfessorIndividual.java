package org.example.professores.Composite;

import org.example.entities.Professor;

public class ProfessorIndividual extends Professor {
    private String nome;
    private String disciplina;

    public ProfessorIndividual(String nome, String disciplina) {
        this.nome = nome;
        this.disciplina = disciplina;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Professor: " + nome + ", Disciplina: " + disciplina);
    }
}
