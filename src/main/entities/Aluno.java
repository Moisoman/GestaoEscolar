package org.example.entities;

import org.example.comunicados.Mediator.ComunicadoMediator;

public class Aluno extends Pessoa {
    private ComunicadoMediator mediator;

    public Aluno(String nome, int idade, ComunicadoMediator mediator) {
        super(nome, idade);
        this.mediator = mediator;
    }

    public void receberComunicado(String comunicado) {
        System.out.println("Aluno " + nome + " recebeu o comunicado: " + comunicado);
    }

    public void enviarComunicado(String comunicado) {
        System.out.println("Aluno " + nome + " enviou um comunicado: " + comunicado);
        mediator.enviarComunicado(comunicado, this);  // O mediador envia para todos os outros alunos
    }


}
