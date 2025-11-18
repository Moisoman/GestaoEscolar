package java.org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String numeroTurma;
    private String horario;
    private Curso curso;
    private ProfessorCoordenador professor;
    private List<String> alunos;

    public Turma(String numeroTurma, String horario, Curso curso, ProfessorCoordenador professor) {
        this.numeroTurma = numeroTurma;
        this.horario = horario;
        this.curso = curso;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(String aluno) {
        alunos.add(aluno);
    }

    public void exibirInformacoesTurma() {
        System.out.println("Turma: " + numeroTurma + ", Horário: " + horario);
        curso.exibirCurso();
        System.out.println("Professor: " + professor);
        System.out.println("Alunos: " + String.join(", ", alunos));
    }
}
