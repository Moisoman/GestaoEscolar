package java.org.example.comunicados.Mediator;

import java.org.example.entities.Aluno;

public class MediatorService {
    public static void main(String[] args) {
        EscolaMediator mediador = new EscolaMediator();

        Aluno aluno1 = new Aluno("João",  mediador,9);
        Aluno aluno2 = new Aluno("Maria",  mediador,8);
        Aluno aluno3 = new Aluno("Pedro",  mediador,7);

        mediador.adicionarAluno(aluno1);
        mediador.adicionarAluno(aluno2);
        mediador.adicionarAluno(aluno3);

        aluno1.enviarComunicado("Aulas serão canceladas amanhã.");

        aluno2.enviarComunicado("Lembrete: provas começam na próxima semana.");
    }
}
