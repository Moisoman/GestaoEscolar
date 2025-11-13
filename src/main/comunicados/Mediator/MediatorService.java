package org.example.comunicados.Mediator;

import org.example.entities.Aluno;

public class MediatorService {
    public static void main(String[] args) {
        EscolaMediator mediador = new EscolaMediator();

        Aluno aluno1 = new Aluno("João", 16, mediador);
        Aluno aluno2 = new Aluno("Maria", 15, mediador);
        Aluno aluno3 = new Aluno("Pedro", 17, mediador);

        mediador.adicionarAluno(aluno1);
        mediador.adicionarAluno(aluno2);
        mediador.adicionarAluno(aluno3);

        aluno1.enviarComunicado("Aulas serão canceladas amanhã.");

        aluno2.enviarComunicado("Lembrete: provas começam na próxima semana.");
    }
}
