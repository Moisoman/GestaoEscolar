package java.org.example.comunicados.Mediator;

import java.org.example.entities.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Faz a comunicação de alunos por meio de um mediador
 */
public class EscolaMediator implements ComunicadoMediator {
    private List<Aluno> alunos;

    public EscolaMediator() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public void enviarComunicado(String comunicado, Aluno aluno) {
        for (Aluno a : alunos) {
            if (a != aluno) {
                a.receberComunicado(comunicado);
            }
        }
    }
}
